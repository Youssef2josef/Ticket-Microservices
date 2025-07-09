package com.stageb2m.ticketservice.dto;


import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class DisplayTicketRequest {

    private String priority;
    private String status;
    private String employeeName;
}
