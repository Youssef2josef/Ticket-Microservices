package com.stageb2m.ticketservice.service;

import com.stageb2m.ticketservice.dto.TicketDtoResponse;

import java.util.Map;

public interface ArchiveTicketService {

    /**
     * Archives a ticket based on its title and user infos.
     *
     * @param title The title of the ticket to be archived.
     * @param name The name of the itSupport to be archived.
     * @param lastname The lastname of the itSupport to be archived.
     * @return A message indicating the result of the archiving operation.
     */
    Map<String, TicketDtoResponse> archiveTicketByTitle(String name,String lastname,String title);



}
