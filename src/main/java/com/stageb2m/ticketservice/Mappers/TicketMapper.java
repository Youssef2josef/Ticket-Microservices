package com.stageb2m.ticketservice.Mappers;

import com.stageb2m.ticketservice.dto.AttachmentDto;
import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.models.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
                .finishedAt(ticket.getArchivedAt())
                .noteUpdatedDescription(ticket.getNoteUpdatedDescription())
                .noteUpdatedBy(ticket.getNoteUpdatedBy())
                .employeeName(ticket.getEmployeeName())
                .itSupportId(ticket.getItSupportId())
                .choix(ticket.getChoix())
                .section(ticket.getSection())
                .storyPoint(ticket.getStoryPoint())
                .remaining(ticket.getRemaining())
                .attachments(TicketMapper.toAttachmentDto(ticket.getAttachments()))
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
                .choix(ticket.getChoix())
                .section(ticket.getSection())
                .storyPoint(ticket.getStoryPoint())
                .remaining(ticket.getRemaining())
                .attachments(TicketMapper.toAttachmentDto(ticket.getAttachments()))
                .build();
    }

    public static List<AttachmentDto> toAttachmentDto(List<Attachment> attachments){
        if (attachments == null) return List.of();

        return attachments.stream()
                .map(attachment -> new AttachmentDto(
                        attachment.getFilename(),
                        attachment.getMimeType(),
                        attachment.getFormat()))
                .toList();
    }
    public static PriorityLevel fromLevel(int level) {
        for (PriorityLevel p : PriorityLevel.values()) {
            if (p.getLevel() == level) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid priority level: " + level);
    }
}
