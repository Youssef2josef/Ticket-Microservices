package com.stageb2m.ticketservice.dto;

import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UpdateTicketRequest {

    private String title;
    // Titre globale de ticket
    private String libelle;
    private String description;
    private String status;
    private int itSupportId;
    private String itSupportName;
    private String itSupportEmail;
    private String noteUpdatedDescription;
    private String noteUpdatedBy;
    private String choice;
}
