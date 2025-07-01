package com.stageb2m.ticketservice.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ticket_log")
public class TicketLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ticketId; // le ticket concerné
    private String fieldChanged;
    private String oldValue;
    private String newValue;
    private String changedBy;
    private LocalDateTime changedAt;
}
