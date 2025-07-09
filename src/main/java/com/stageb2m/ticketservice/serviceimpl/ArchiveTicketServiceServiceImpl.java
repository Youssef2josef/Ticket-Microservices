package com.stageb2m.ticketservice.serviceimpl;

import com.stageb2m.ticketservice.Mappers.TicketMapper;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.models.Status;
import com.stageb2m.ticketservice.models.TicketLog;
import com.stageb2m.ticketservice.repositories.TicketLogRepository;
import com.stageb2m.ticketservice.repositories.TicketRepository;
import com.stageb2m.ticketservice.service.ArchiveTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArchiveTicketServiceServiceImpl implements ArchiveTicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketLogRepository ticketLogRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, TicketDtoResponse> archiveTicketByTitle(String name,String lastname,String title) {
        var ticket = ticketRepository.findByTitle(title);

        if (ticket != null) {
            var ticketLog = new TicketLog();
            ticketLog.setTicketId(ticket.getId());
            ticketLog.setTitle(ticket.getTitle());
            ticketLog.setFieldChanged("status");
            ticketLog.setOldValue(String.valueOf(ticket.getStatus()));
            ticketLog.setNewValue(Status.Closed.name());
            ticketLog.setChangedBy("user: " + name + " " + lastname);
            ticketLog.setChangedAt(LocalDateTime.now());
            ticketLogRepository.save(ticketLog);

            ticket.setStatus(Status.Closed);
            ticket.setArchivedAt(LocalDateTime.now());
            ticket.setUpdatedAt(LocalDateTime.now());
            ticket.setNoteUpdatedDescription("Archived By: "+ name + " " + lastname);
            ticketRepository.save(ticket);

            TicketDtoResponse dto = TicketMapper.toResponse(ticket);
            return Map.of("ticket", dto);
        }
        Map<String, TicketDtoResponse> error = new HashMap<>();
        error.put("ticket", null);
        return error;
    }
}
