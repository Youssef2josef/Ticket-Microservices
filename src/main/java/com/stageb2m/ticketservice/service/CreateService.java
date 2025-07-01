package com.stageb2m.ticketservice.service;

import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CreateService {
    /**
     * Creates a new ticket with the provided details and attachments.
     *
     * @param description   The description of the ticket.
     * @param employeeName  The name of the employee creating the ticket.
     * @param prefix        The prefix for the ticket title.
     * @param attachments   A list of attachments for the ticket.
     * @return A map containing the created ticket details.
     */
    Map<String, TicketDtoResponse> createTicket(String description, String employeeName, String prefix,
                                                List<MultipartFile> attachments);

}
