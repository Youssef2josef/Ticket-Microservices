package com.stageb2m.ticketservice.service;

import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.UpdateTicketRequest;

import java.util.Map;

public interface UpdateTicketService {
    /**
     * Updates a ticket with the provided details.
     *
     * @param request  the request containing the updated ticket details
     */
    Map<String, TicketDtoItSupportResponse> updateTicket(UpdateTicketRequest request);



}
