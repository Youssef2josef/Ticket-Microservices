package com.stageb2m.ticketservice.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ticket_history")
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer originalTicketId; // L'ID du ticket d'origine
    private String serialNumber;
    private String title;
    private String libelle;
    private String description;
    private Status status; // sera CLOSED
    private Integer priority;
    private String itSupportName;
    private String itSupportEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime finishedAt;
    private String noteUpdatedDescription;
    private String noteUpdatedBy;
    private String employeeName;
    private String itSupportId;

    @ElementCollection
    private List<Attachment> attachments;

    // date d'archivage pour l'historique
    private LocalDateTime archivedAt;
}
