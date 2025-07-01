package com.stageb2m.ticketservice.Mappers;

import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.models.Ticket;

public class TicketMapper {

    public static TicketDtoItSupportResponse toItSupportResponse(Ticket ticket) {
        if (ticket == null) return null;

        return TicketDtoItSupportResponse.builder()
                .title(ticket.getTitle())
                .libelle(ticket.getLibelle())
                .description(ticket.getDescription())
                .status(ticket.getStatus())
                .priority(String.valueOf(ticket.getPriority()))
                .itSupportName(ticket.getItSupportName())
                .itSupportEmail(ticket.getItSupportEmail())
                .createdAt(ticket.getCreatedAt())
                .updatedAt(ticket.getUpdatedAt())
                .finishedAt(ticket.getFinishedAt())
                .noteUpdatedDescription(ticket.getNoteUpdatedDescription())
                .noteUpdatedBy(ticket.getNoteUpdatedBy())
                .employeeName(ticket.getEmployeeName())
                .itSupportId(ticket.getItSupportId())
                .attachments(ticket.getAttachments())
                .build();
    }

    public static TicketDtoResponse toResponse(Ticket ticket) {
        if (ticket == null) return null;

        return TicketDtoResponse.builder()
                .title(ticket.getTitle())
                .libelle(ticket.getLibelle())
                .description(ticket.getDescription())
                .status(ticket.getStatus())
                .priority(String.valueOf(ticket.getPriority()))
                .itSupportName(ticket.getItSupportName())
                .itSupportEmail(ticket.getItSupportEmail())
                .employeeName(ticket.getEmployeeName())
                .noteUpdatedDescription(ticket.getNoteUpdatedDescription())
                .attachments(ticket.getAttachments())
                .build();
    }
}
