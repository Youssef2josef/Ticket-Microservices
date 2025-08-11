package com.stageb2m.ticketservice.controller;

import com.stageb2m.ticketservice.Mappers.TicketMapper;
import com.stageb2m.ticketservice.dto.DisplayTicketRequest;
import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.models.Choix;
import com.stageb2m.ticketservice.models.Section;
import com.stageb2m.ticketservice.service.DisplayTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/ticket/display")
@CrossOrigin("http://localhost:4200")

public class DisplayTicketController {
    @Autowired
    DisplayTicketService displayTicketService;

    // It support
    @GetMapping("/all")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayAllTickets() {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayAllTickets();
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // It Support
    @PostMapping("/status")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayTicketsByStatus(
            @RequestBody String status) {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayTicketsByStatus(status);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // It support
    @PostMapping("/it-support")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayTicketsByItSupport(
            @RequestBody String itSupportName) {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayTicketsByItSupport(itSupportName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Employee
    @PostMapping("/employee")
    public ResponseEntity<List<TicketDtoResponse>> displayTicketsByEmployee(
            @RequestBody String employeeName) {
        List<TicketDtoResponse> tickets = displayTicketService.displayTicketsByEmployee(employeeName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Employee
    @PostMapping("/title/employee")
    public ResponseEntity<TicketDtoResponse> displayTicketByTitleEmployee(
            @RequestBody String title) {
        TicketDtoResponse ticket = displayTicketService.displayTicketByTitleEmployee(title);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }
    // It support
    @PostMapping("/title/it-support")
    public ResponseEntity<TicketDtoItSupportResponse> displayTicketByTitleItSupport(
            @RequestBody String title) {
        TicketDtoItSupportResponse ticket = displayTicketService.displayTicketByTitleItSupport(title);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }
    // It support
    @PostMapping("/priority")
    public ResponseEntity<List<TicketDtoResponse>> displayAllTicketsByPriority(
            @RequestBody String priority) {
        List<TicketDtoResponse> tickets = displayTicketService.displayAllTicketsByPriority(priority);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // It support
    // employeeName in dto is null
    @PostMapping("/priority/status")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayAllTicketsByPriorityAndStatus(
            @RequestBody DisplayTicketRequest displayTicketRequest) {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayAllTicketsByPriorityAndStatus(
                displayTicketRequest.getPriority(), displayTicketRequest.getStatus());
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Employee
    @PostMapping("/priority/employee")
    public ResponseEntity<List<TicketDtoResponse>> displayAllTicketsByPriorityAndEmployee(
            @RequestBody DisplayTicketRequest displayTicketRequest) {
        List<TicketDtoResponse> tickets = displayTicketService.displayAllTicketsByPriorityAndEmployee(
                displayTicketRequest.getPriority(), displayTicketRequest.getEmployeeName());
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Employee
    @PostMapping("/priority/employee/status")
    public ResponseEntity<List<TicketDtoResponse>> displayAllTicketsByPriorityAndEmployeeAndStatus(
            @RequestBody DisplayTicketRequest displayTicketRequest) {
        List<TicketDtoResponse> tickets = displayTicketService.displayAllTicketsByPriorityAndStatusAndEmployee(
                displayTicketRequest.getPriority(), displayTicketRequest.getStatus(),
                displayTicketRequest.getEmployeeName());
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // It support
    @GetMapping("/inProgress")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayInProgressTickets() {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayTopInProgressTickets();
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // It support
    @GetMapping("/closed")
    public ResponseEntity<List<TicketDtoItSupportResponse>> displayClosedTickets() {
        List<TicketDtoItSupportResponse> tickets = displayTicketService.displayTopClosedTickets();
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Employee
    @GetMapping("/inProgress/employee")
    public ResponseEntity<List<TicketDtoResponse>> displayInProgressTicketsByEmployee(
            @RequestBody String employeeName) {
        List<TicketDtoResponse> tickets = displayTicketService
                .displayTopInProgressTicketsByEmployee(employeeName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Employee
    @GetMapping("/closed/employee")
    public ResponseEntity<List<TicketDtoResponse>> displayClosedTicketsByEmployee(
            @RequestBody String employeeName) {
        List<TicketDtoResponse> tickets = displayTicketService
                .displayTopClosedTicketsByEmployee(employeeName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Employee
    @GetMapping("/open/employee")
    public ResponseEntity<List<TicketDtoResponse>> displayViewedTicketsByEmployee(
            @RequestBody String employeeName) {
        List<TicketDtoResponse> tickets = displayTicketService
                .displayTopViewedTicketsByEmployee(employeeName);
        return tickets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tickets);
    }
    // Both
    // It support
    // Employee
    @GetMapping("/sections")
    public ResponseEntity<List<String>> getAllSections() {
        List<String> sections = Arrays.stream(Section.values())
                .map(Section::getLabel)
                .toList();
        return ResponseEntity.ok(sections);
    }
    // Both
    // It support
    // Employee
    @GetMapping("/choix")
    public ResponseEntity<List<String>> getAllChoices() {
        List<String> choices = Arrays.stream(Choix.values())
                .map(Choix::getLabel)
                .toList();
        return ResponseEntity.ok(choices);
    }
}