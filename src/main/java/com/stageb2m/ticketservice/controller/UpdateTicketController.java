package com.stageb2m.ticketservice.controller;


import com.stageb2m.ticketservice.Mappers.TicketMapper;
import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.UpdateTicketRequest;
import com.stageb2m.ticketservice.service.UpdateTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/ticket")
@CrossOrigin("localhost:4200")
public class UpdateTicketController {
    @Autowired
    UpdateTicketService updateTicketService;

    // It support
    @PutMapping("/update")
    public Map<String, TicketDtoItSupportResponse> updateTicket(@RequestBody UpdateTicketRequest request) {
        return Map.of("ticket",updateTicketService.updateTicket(request).get("ticket"));
    }
}
