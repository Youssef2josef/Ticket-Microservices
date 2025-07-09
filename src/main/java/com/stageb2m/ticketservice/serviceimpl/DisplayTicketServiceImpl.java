package com.stageb2m.ticketservice.serviceimpl;

import com.stageb2m.ticketservice.Mappers.TicketMapper;
import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;
import com.stageb2m.ticketservice.models.PriorityLevel;
import com.stageb2m.ticketservice.models.Status;
import com.stageb2m.ticketservice.models.Ticket;
import com.stageb2m.ticketservice.repositories.TicketRepository;
import com.stageb2m.ticketservice.service.DisplayTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisplayTicketServiceImpl implements DisplayTicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    @Transactional(readOnly = true)
    public TicketDtoResponse displayTicketByTitleEmployee(String title) {
        Ticket ticket = ticketRepository.findByTitle(title);

        return ticket != null ? TicketMapper.toResponse(ticket) : null;
    }

    @Override
    @Transactional(readOnly = true)
    public TicketDtoItSupportResponse displayTicketByTitleItSupport(String title) {
        Ticket ticket = ticketRepository.findByTitle(title);

        return ticket != null ? TicketMapper.toItSupportResponse(ticket) : null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoResponse> displayTicketsByEmployee(String employeeName) {
        List<Ticket> tickets = ticketRepository.findByEmployeeName(employeeName);
        return tickets.stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoItSupportResponse> displayTicketsByItSupport(String itSupportName) {
        List<Ticket> tickets = ticketRepository.findByItSupportName(itSupportName);
        return tickets.stream()
                .map(TicketMapper::toItSupportResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoItSupportResponse> displayTicketsByStatus(String status) {
        List<Ticket> tickets = ticketRepository.findByStatus(Status.valueOf(status));

        return tickets.stream()
                .map(TicketMapper::toItSupportResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoItSupportResponse> displayAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();

        return  tickets.stream()
                .map(TicketMapper::toItSupportResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoResponse> displayAllTicketsByPriority(String priority) {
        List<Ticket> tickets = ticketRepository.findByPriority(PriorityLevel.valueOf(priority));

        return tickets.stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoItSupportResponse> displayAllTicketsByPriorityAndStatus(String priority, String status) {

        List<Ticket> tickets = ticketRepository.findByPriorityAndStatus(PriorityLevel.valueOf(priority), Status.valueOf(status));

        return tickets.stream()
                .map(TicketMapper::toItSupportResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoResponse> displayAllTicketsByPriorityAndStatusAndEmployee(String priority, String status, String employeeName) {

        List<Ticket> tickets = ticketRepository.findByPriorityAndStatusAndEmployeeName(
                PriorityLevel.valueOf(priority), Status.valueOf(status), employeeName);

        return tickets.stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoResponse> displayAllTicketsByPriorityAndEmployee(String priority, String employeeName) {

        List<Ticket> tickets = ticketRepository.findByPriorityAndEmployeeName(PriorityLevel.valueOf(priority), employeeName);

        return tickets.stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoItSupportResponse> displayTopInProgressTickets() {
        List<Ticket> tickets = ticketRepository.findTopInProgress();

        return tickets.stream()
                .map(TicketMapper::toItSupportResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoItSupportResponse> displayTopClosedTickets() {
        List<Ticket> tickets = ticketRepository.findTopClosed();

        return tickets.stream()
                .map(TicketMapper::toItSupportResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoResponse> displayTopInProgressTicketsByEmployee(String employeeName) {
        List<Ticket> tickets = ticketRepository.findTopInProgressByEmployee(employeeName);
        return tickets.stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoResponse> displayTopViewedTicketsByEmployee(String employeeName) {
        List<Ticket> tickets = ticketRepository.findTopViewedByItSupportEmployee(employeeName);
        return tickets.stream()
                .map(TicketMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDtoResponse> displayTopClosedTicketsByEmployee(String employeeName) {
        List<Ticket> tickets = ticketRepository.findTopClosedEmployee(employeeName);
        return tickets.stream()
                .map(TicketMapper::toResponse)
                .toList();
    }
}