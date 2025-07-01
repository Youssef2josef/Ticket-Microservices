package com.stageb2m.ticketservice.controller;

import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.service.DisplayTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ticket/display")
@CrossOrigin("http://localhost:4200")

public class DisplayTicketController {
    @Autowired
    DisplayTicketService displayTicketService;

    @GetMapping("/all")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayAllTickets() {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayAllTickets();
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    @GetMapping("/status")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayTicketsByStatus(String status) {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayTicketsByStatus(status);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    @GetMapping("/it-support")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayTicketsByItSupport(String itSupportName) {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayTicketsByItSupport(itSupportName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    @GetMapping("/employee")
    public ResponseEntity<List<TicketDtoResponse>> displayTicketsByEmployee(String employeeName) {
        List<TicketDtoResponse> tickets = displayTicketService.displayTicketsByEmployee(employeeName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    @GetMapping("/title/employee")
    public ResponseEntity<TicketDtoResponse> displayTicketByTitleEmployee(String title) {
        TicketDtoResponse ticket = displayTicketService.displayTicketByTitleEmployee(title);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }
    @GetMapping("/title/it-support")
    public ResponseEntity<TicketDtoItSupportResponse> displayTicketByTitleItSupport(String title) {
        TicketDtoItSupportResponse ticket = displayTicketService.displayTicketByTitleItSupport(title);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }
    @GetMapping("/priority")
    public ResponseEntity<List<TicketDtoResponse>> displayAllTicketsByPriority(String priority) {
        List<TicketDtoResponse> tickets = displayTicketService.displayAllTicketsByPriority(priority);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    @GetMapping("/priority/status")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayAllTicketsByPriorityAndStatus(String priority, String status) {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayAllTicketsByPriorityAndStatus(priority, status);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    @GetMapping("/priority/employee")
    public ResponseEntity<List<TicketDtoResponse>> displayAllTicketsByPriorityAndEmployee(String priority, String employeeName) {
        List<TicketDtoResponse> tickets = displayTicketService.displayAllTicketsByPriorityAndEmployee(priority, employeeName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    @GetMapping("/priority/employee/status")
    public ResponseEntity<List<TicketDtoResponse>> displayAllTicketsByPriorityAndEmployeeAndStatus(String priority, String employeeName, String status) {
        List<TicketDtoResponse> tickets = displayTicketService.displayAllTicketsByPriorityAndStatusAndEmployee(priority, employeeName, status);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }


}
