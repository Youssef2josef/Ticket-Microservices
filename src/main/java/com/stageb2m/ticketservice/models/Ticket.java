package com.stageb2m.ticketservice.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "ticket_db")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, updatable = false)
    private String serialNumber;
    //Attribut pour distinguer les ticket sous format: prefix-serialNumber-employeeName
    @Column(unique = true, updatable = false)
    private String title;
    //Titre globale de ticket
    private String libelle;
    private String description;
    private Status status;
    @Enumerated(EnumType.STRING)
    private PriorityLevel priority;
    private String itSupportName;
    private String itSupportEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime archivedAt;
    private String noteUpdatedDescription;
    private String noteUpdatedBy;
    private String employeeName;
    private int itSupportId;

    private Choix choix;
    private Section section;
    //Durée de ticket
    private int storyPoint;
    private int remaining;

    @ElementCollection
    @CollectionTable(
            name = "ticket_attachments",
            joinColumns = @JoinColumn(name = "ticket_id")
    )
    private List<Attachment> attachments;

}
