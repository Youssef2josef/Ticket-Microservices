package com.stageb2m.ticketservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket_log")
public class TicketLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;
    private String title;
    private String fieldChanged;
    private String oldValue;
    private String newValue;
    private String details;
    private String changedBy;
    private LocalDateTime changedAt;
}
