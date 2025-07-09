package com.stageb2m.ticketservice.service;

import com.stageb2m.ticketservice.dto.TicketDtoRequest;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CreateService {
    /**
     * Creates a new ticket with the provided details and attachments.
     *
     * @param ticketDtoRequest   The infos of creation request of the ticket.
     * @param attachments   A list of attachments for the ticket.
     * @return A map containing the created ticket details.
     */
    Map<String, TicketDtoResponse> createTicket(TicketDtoRequest ticketDtoRequest, List<MultipartFile> attachments);
}
