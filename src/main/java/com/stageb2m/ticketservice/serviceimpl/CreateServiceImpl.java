package com.stageb2m.ticketservice.serviceimpl;

import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.models.Attachment;
import com.stageb2m.ticketservice.models.Status;
import com.stageb2m.ticketservice.models.Ticket;
import com.stageb2m.ticketservice.repositories.TicketRepository;
import com.stageb2m.ticketservice.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Override
    public Map<String, TicketDtoResponse> createTicket(String description, String employeeName, String prefix,
                                                       List<MultipartFile> attachments) {
        var ticket = new Ticket();
        String serial = generateUniqueSerial(6);
        ticket.setSerialNumber(serial);

        Map<String, TicketDtoResponse> result = new HashMap<>();
        if (employeeName != null) {
            String name = ticket.getEmployeeName().toLowerCase().replaceAll("\\s+", "");

            ticket.setTitle(prefix + "-" + serial + "-" + name);
            ticket.setStatus(Status.OPEN);
            ticket.setCreatedAt(LocalDateTime.now());
            ticket.setUpdatedAt(null);
            ticket.setDescription(description);
            ticket.setFinishedAt(null);
            ticket.setNoteUpdatedDescription(null);
            ticket.setItSupportName(null);
            ticket.setItSupportEmail(null);
            ticket.setEmployeeName(employeeName);
            ticket.setItSupportId(null);

            // Gestion des attachments
            if (attachments != null && !attachments.isEmpty()) {
                List<Attachment> attachmentList = attachments.stream().map(file -> {
                    try {
                        return new Attachment(
                                file.getOriginalFilename(),
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

            var ticketDto = TicketDtoResponse.builder()
                    .title(ticket.getTitle())
                    .description(description)
                    .status(ticket.getStatus())
                    .itSupportName(ticket.getItSupportName())
                    .itSupportEmail(ticket.getItSupportEmail())
                    .employeeName(employeeName)
                    .noteUpdatedDescription(ticket.getNoteUpdatedDescription())
                    .attachments(ticket.getAttachments())
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
