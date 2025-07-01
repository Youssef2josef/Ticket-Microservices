package com.stageb2m.ticketservice.dto;

import com.stageb2m.ticketservice.models.Attachment;
import com.stageb2m.ticketservice.models.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Data
public class TicketDtoItSupportResponse {
    private String title;
    private String libelle;
    private String description;
    private Status status;
    private String priority;
    private String itSupportName;
    private String itSupportEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime finishedAt;
    private String noteUpdatedDescription;
    private String noteUpdatedBy;
    private String employeeName;
    private String itSupportId;
    private List<Attachment> attachments;
}
