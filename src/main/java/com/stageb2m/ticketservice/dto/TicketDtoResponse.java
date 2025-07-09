package com.stageb2m.ticketservice.dto;

import com.stageb2m.ticketservice.models.Attachment;
import com.stageb2m.ticketservice.models.Choix;
import com.stageb2m.ticketservice.models.Section;
import com.stageb2m.ticketservice.models.Status;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
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
    private Choix choix;
    private Section section;
    private int storyPoint;
    private int remaining;
    private List<AttachmentDto> attachments;
}
