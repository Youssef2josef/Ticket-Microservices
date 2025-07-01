package com.stageb2m.ticketservice.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "ticket_db")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, updatable = false)
    private String serialNumber;
    private String title;
    private String libelle;
    private String description;
    private Status status;
    @Enumerated(EnumType.STRING)
    private PriorityLevel priority;
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
    @CollectionTable(
            name = "ticket_attachments",
            joinColumns = @JoinColumn(name = "ticket_id")
    )
    private List<Attachment> attachments;

}
