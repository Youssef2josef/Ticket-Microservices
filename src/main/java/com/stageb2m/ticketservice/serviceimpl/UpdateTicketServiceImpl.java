package com.stageb2m.ticketservice.serviceimpl;


import com.stageb2m.ticketservice.Mappers.TicketMapper;
import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.UpdateTicketRequest;
import com.stageb2m.ticketservice.models.Status;
import com.stageb2m.ticketservice.models.Ticket;
import com.stageb2m.ticketservice.models.TicketLog;
import com.stageb2m.ticketservice.repositories.TicketLogRepository;
import com.stageb2m.ticketservice.repositories.TicketRepository;
import com.stageb2m.ticketservice.service.UpdateTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UpdateTicketServiceImpl implements UpdateTicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketLogRepository ticketLogRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public Map<String, TicketDtoItSupportResponse> updateTicket(UpdateTicketRequest request) {

        Ticket ticket = ticketRepository.findByTitle(request.getTitle());

        Map<String, TicketDtoItSupportResponse> result = new HashMap<>();
        TicketLog ticketLog = new TicketLog();

        if(ticket != null) {

            if(request.getLibelle() != null) {
                ticketLog.setFieldChanged("Libellé du ticket");
                ticketLog.setOldValue(request.getLibelle());
                ticketLog.setNewValue(request.getLibelle());
                ticket.setLibelle(request.getLibelle());
            }
            if(request.getDescription() != null) {
                ticketLog.setFieldChanged("Description du ticket");
                ticketLog.setOldValue(ticket.getDescription());
                ticketLog.setNewValue(request.getDescription());
                ticket.setDescription(request.getDescription());
            }
            if(request.getStatus() != null){
                ticketLog.setFieldChanged("Status du ticket");
                ticketLog.setOldValue(String.valueOf(ticket.getStatus()));
                ticketLog.setNewValue(request.getStatus());
                ticket.setStatus(Status.valueOf(request.getStatus()));
            }
            if(request.getItSupportEmail() != null && request.getItSupportId() != 0
            && request.getItSupportName() != null){
                if(Objects.equals(request.getChoice(), "affectation")) {
                    ticketLog.setFieldChanged("Credentials of the ITSupport handler");
                    ticketLog.setOldValue("Aucun it support correspondant");
                    ticketLog.setNewValue("Name of it support: " + request.getItSupportName()
                            + " Email of it support: " + request.getItSupportEmail());
                    ticket.setItSupportId(request.getItSupportId());
                    ticket.setItSupportName(request.getItSupportName());
                    ticket.setItSupportEmail(request.getItSupportEmail());
                    ticket.setNoteUpdatedDescription("Updated");
                }
                ticketLog.setChangedBy("User: " + request.getItSupportName());
                if (request.getStatus() != null) {
                    ticket.setNoteUpdatedDescription(request.getStatus());
                } else {
                    ticket.setNoteUpdatedDescription("Updated");
                }
                ticket.setNoteUpdatedBy("User: " + request.getItSupportName());
            }
            ticketLog.setChangedAt(LocalDateTime.now());
            ticket.setUpdatedAt(LocalDateTime.now());
            ticketLog.setDetails(request.getNoteUpdatedDescription());
            ticketLog.setTicketId(ticket.getId());
            ticketLog.setTitle(ticket.getTitle());


            ticketLogRepository.save(ticketLog);

            ticketRepository.save(ticket);
            result.put("ticket",TicketMapper.toItSupportResponse(ticket));
        }else{
            result.put("ticket",null);
        }

        return result;
    }
}
