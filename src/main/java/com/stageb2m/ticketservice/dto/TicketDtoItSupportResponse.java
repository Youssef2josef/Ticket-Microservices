package com.stageb2m.ticketservice.dto;

import com.stageb2m.ticketservice.models.Attachment;
import com.stageb2m.ticketservice.models.Choix;
import com.stageb2m.ticketservice.models.Section;
import com.stageb2m.ticketservice.models.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
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
    private int itSupportId;
    private Choix choix;
    private Section section;
    private int storyPoint;
    private int remaining;
    private List<AttachmentDto> attachments;
}
