package com.stageb2m.ticketservice.controller;

import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ticket/create")
@CrossOrigin("http://localhost:4200")

public class CreateTicketController {
    @Autowired
    CreateService createService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> createTicket(
            @RequestParam String description,
            @RequestParam String employeeName,
            @RequestParam String prefix,
            @RequestParam Integer priority,
            @RequestPart(required = false) List<MultipartFile> attachments) {

        if (priority < 1 || priority > 5) {
            return ResponseEntity.badRequest().body(Map.of("error", "Priority must be between 1 and 5"));
        }

        Map<String, TicketDtoResponse> response = createService.createTicket(description, employeeName, prefix,
                attachments);

         // If the ticket is not present in the response, create a new TicketDtoResponse
        return response.get("ticket")== null ? ResponseEntity.badRequest().body(Map.of("error", "Ticket creation failed")) :
                ResponseEntity.ok(Map.of("message", "Ticket created successfully", "ticket", response.get("ticket").getTitle()));
    }
}
