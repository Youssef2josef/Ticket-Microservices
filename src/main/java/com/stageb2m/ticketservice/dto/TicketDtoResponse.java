package com.stageb2m.ticketservice.dto;

import com.stageb2m.ticketservice.models.Attachment;
import com.stageb2m.ticketservice.models.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TicketDtoResponse {
    private String title;
    private String libelle;
    private String description;
    private Status status;
    private String priority;
    private String itSupportName;
    private String itSupportEmail;
    private String employeeName;
    private String noteUpdatedDescription;
    private List<Attachment> attachments;
}
