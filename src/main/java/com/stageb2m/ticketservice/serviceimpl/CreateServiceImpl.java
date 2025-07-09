package com.stageb2m.ticketservice.serviceimpl;

import com.stageb2m.ticketservice.Mappers.TicketMapper;
import com.stageb2m.ticketservice.dto.TicketDtoRequest;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.models.*;
import com.stageb2m.ticketservice.repositories.TicketLogRepository;
import com.stageb2m.ticketservice.repositories.TicketRepository;
import com.stageb2m.ticketservice.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Service
public class CreateServiceImpl implements CreateService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketLogRepository ticketLogRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, TicketDtoResponse> createTicket(TicketDtoRequest ticketDtoRequest,
                                                       List<MultipartFile> attachments) {
        var ticket = new Ticket();
        String serial = generateUniqueSerial(6);
        ticket.setSerialNumber(serial);

        Map<String, TicketDtoResponse> result = new HashMap<>();
        if (ticketDtoRequest.getEmployeeName() != null) {
            String name = ticketDtoRequest.getEmployeeName().toLowerCase().replaceAll("\\s+", "");

            ticket.setTitle(ticketDtoRequest.getPrefix() + "-" + serial + "-" + name);
            ticket.setLibelle(ticketDtoRequest.getLibelle());
            ticket.setStatus(Status.Open);
            ticket.setCreatedAt(LocalDateTime.now());
            ticket.setUpdatedAt(null);
            ticket.setDescription(ticketDtoRequest.getDescription());
            ticket.setArchivedAt(null);
            ticket.setNoteUpdatedDescription(null);
            ticket.setPriority(TicketMapper.fromLevel(ticketDtoRequest.getPriority()));
            ticket.setNoteUpdatedBy(null);
            ticket.setChoix(ticketDtoRequest.getChoix() != null ?
                            Choix.fromLabel(ticketDtoRequest.getChoix()) :
                            Choix.reclamation);
            ticket.setSection(ticketDtoRequest.getSection() != null ?
                            Section.fromLabel(ticketDtoRequest.getSection()) :
                            Section.support);
            ticket.setItSupportName(null);
            ticket.setItSupportEmail(null);
            ticket.setEmployeeName(name);
            ticket.setItSupportId(0);
            ticket.setStoryPoint(ticketDtoRequest.getStoryPoint());
            ticket.setRemaining(ticketDtoRequest.getRemaining());
            try {
                ticket.setChoix(Choix.fromLabel(ticketDtoRequest.getChoix()));
            } catch (IllegalArgumentException e) {
                ticket.setSection(Section.fromLabel(ticketDtoRequest.getSection()));
            }
            try {
                ticket.setSection(Section.fromLabel(ticketDtoRequest.getSection()));
            } catch (IllegalArgumentException e) {
                ticket.setSection(Section.support);
            }
            // Gestion des pièces jointes
            if (attachments != null && !attachments.isEmpty()) {
                List<Attachment> attachmentList = attachments.stream().map(file -> {
                    try {
                        String fileName = file.getOriginalFilename();
                        String format = "";

                        if(fileName.contains(".")){
                            format = fileName.substring(fileName.lastIndexOf(".") + 1);
                        }

                        return new Attachment(
                                file.getOriginalFilename(),
                                format,
                                file.getContentType(),
                                file.getBytes()
                        );
                    } catch (Exception e) {
                        throw new RuntimeException("Erreur de lecture du fichier : " + file.getOriginalFilename(), e);
                    }
                }).toList();
                ticket.setAttachments(attachmentList);
            }

            // Enregistrement de ticket
            ticket = ticketRepository.save(ticket);

            var ticketLog = new TicketLog();

            ticketLog.setTicketId(ticket.getId());
            ticketLog.setTitle(ticket.getTitle());
            ticketLog.setFieldChanged("all");
            ticketLog.setOldValue(null);
            ticketLog.setNewValue("all");
            ticketLog.setDetails("Ticket created with all fields");
            ticketLog.setChangedBy(ticket.getEmployeeName());
            ticketLog.setChangedAt(LocalDateTime.now());
            ticketLogRepository.save(ticketLog);

            var ticketDto = TicketDtoResponse.builder()
                    .title(ticket.getTitle())
                    .description(ticket.getDescription())
                    .status(ticket.getStatus())
                    .itSupportName(ticket.getItSupportName())
                    .itSupportEmail(ticket.getItSupportEmail())
                    .employeeName(ticket.getEmployeeName())
                    .noteUpdatedDescription(ticket.getNoteUpdatedDescription())
                    .attachments(TicketMapper.toAttachmentDto(ticket.getAttachments()))
                    .build();
                result.put("ticket", ticketDto);
        }else {
            result.put("ticket", null);
        }
        return  result;
    }
    private String generateUniqueSerial(int length) {
        String chars = "0123456789";
        Random random = new Random();

        String serial;
        do {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(chars.charAt(random.nextInt(chars.length())));
            }
            serial = builder.toString();
        } while (ticketRepository.existsBySerialNumber(serial));
        return serial;
    }
}