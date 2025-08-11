package com.stageb2m.ticketservice.controller;


import com.stageb2m.ticketservice.dto.ArchiveTicketRequest;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.service.ArchiveTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ticket/archive")
@CrossOrigin("http://localhost:4200")
public class ArchiveTicketController {

    @Autowired
    private ArchiveTicketService archiveTicketService;

    // It support
    @PostMapping()
    public ResponseEntity<Map<String,TicketDtoResponse>> archiveTicket(
            @RequestBody ArchiveTicketRequest archiveTicketRequest) {

        var res = archiveTicketService.archiveTicketByTitle(archiveTicketRequest.getName(),
                archiveTicketRequest.getLastname(),
                archiveTicketRequest.getTitle());
        return res.get("ticket")!=null ?
                ResponseEntity.ok(res) :
                ResponseEntity.badRequest().body(Map.of("ticket", res.get("ticket")));
    }
}
