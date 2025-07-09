package com.stageb2m.ticketservice.dto;


import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TicketDtoRequest {

    private String libelle;
    private String description;
    private String employeeName;
    private String prefix;
    private int priority;
    private String choix;
    private String section;
    private int storyPoint;
    private int remaining;
}
