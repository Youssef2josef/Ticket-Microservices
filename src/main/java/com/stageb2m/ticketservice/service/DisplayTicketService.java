package com.stageb2m.ticketservice.service;

import com.stageb2m.ticketservice.dto.TicketDtoItSupportResponse;
import com.stageb2m.ticketservice.dto.TicketDtoResponse;

import java.util.List;

public interface DisplayTicketService {
    /**
     * Displays the details of a ticket based on its title to employee only.
     *
     * @param title The title of the ticket to be displayed.
     * @return A map containing the ticket details.
     */
    TicketDtoResponse displayTicketByTitleEmployee(String title);
    /**
     * Displays the details of a ticket based on its title to ItSupport only.
     *
     * @param title The title of the ticket to be displayed.
     * @return A map containing the ticket details.
     */
    TicketDtoItSupportResponse displayTicketByTitleItSupport(String title);
    /**
     * Displays all tickets assigned to a specific employee.
     *
     * @param employeeName The name of the employee whose tickets are to be displayed.
     * @return A map containing the list of tickets assigned to the employee.
     */
    List<TicketDtoResponse> displayTicketsByEmployee(String employeeName);
    /**
     * Displays all tickets assigned to a specific IT support personnel.
     *
     * @param itSupportName The name of the IT support personnel whose tickets are to be displayed.
     * @return A map containing the list of tickets assigned to the IT support personnel.
     */
    List<TicketDtoItSupportResponse> displayTicketsByItSupport(String itSupportName);
    /**
     * Displays all tickets with a specific status.
     *
     * @param status The status of the tickets to be displayed.
     * @return A map containing the list of tickets with the specified status.
     */
    List<TicketDtoItSupportResponse> displayTicketsByStatus(String status);
    /**
     * Displays all tickets.
     *
     * @return A list of all tickets.
     */
    List<TicketDtoItSupportResponse> displayAllTickets();
    /**
     * Displays all tickets assigned to a specific priority tickets.
     *
     * @param priority The priority whose tickets are to be displayed.
     * @return A list of tickets assigned to the correspondence priority.
     */
    List<TicketDtoResponse> displayAllTicketsByPriority(String priority);
    /**
     * Displays all tickets assigned to a specific priority and status.
     *
     * @param priority The priority whose tickets are to be displayed.
     * @param status The status of the tickets to be displayed.
     * @return A list of tickets assigned to the correspondence priority and status.
     */
    List<TicketDtoItSupportResponse> displayAllTicketsByPriorityAndStatus(String priority, String status);
    /**
     * Displays all tickets assigned to a specific priority, status and employee.
     *
     * @param priority The priority whose tickets are to be displayed.
     * @param status The status of the tickets to be displayed.
     * @param employeeName The name of the employee whose tickets are to be displayed.
     * @return A list of tickets assigned to the correspondence priority, status and employee.
     */
    List<TicketDtoResponse> displayAllTicketsByPriorityAndStatusAndEmployee(String priority, String status, String employeeName);
    /**
     * Displays all tickets assigned to a specific priority and employee.
     *
     * @param priority The priority whose tickets are to be displayed.
     * @param employeeName The name of the employee whose tickets are to be displayed.
     * @return A list of tickets assigned to the correspondence priority and employee.
     */
    List<TicketDtoResponse> displayAllTicketsByPriorityAndEmployee(String priority, String employeeName);
    /**
     * Displays the top 10 most recent tickets that are currently in progress.
     *
     * @return A list of the top 10 most recent tickets in progress.
     */
    List<TicketDtoItSupportResponse> displayTopInProgressTickets();
    /**
     * Displays the top 40 most recent tickets that are closed.
     *
     * @return A list of the top 40 most recent closed tickets.
     */
    List<TicketDtoItSupportResponse> displayTopClosedTickets();
    /**
     * Displays the top 10 most recent tickets in progress assigned to a specific employee.
     *
     * @param employeeName The name of the employee whose tickets are to be displayed.
     * @return A list of the top 10 most recent tickets in progress assigned to the employee.
     */
    List<TicketDtoResponse> displayTopInProgressTicketsByEmployee(String employeeName);
    /**
     * Displays the top 10 most recent tickets that are open and assigned to a specific employee.
     *
     * @param employeeName The name of the employee whose tickets are to be displayed.
     * @return A list of the top 10 most recent open tickets assigned to the employee.
     */
    List<TicketDtoResponse> displayTopViewedTicketsByEmployee(String employeeName);
    /**
     * Displays the top 10 most recent closed tickets assigned to a specific employee.
     *
     * @param employeeName The name of the employee whose tickets are to be displayed.
     * @return A list of the top 10 most recent closed tickets assigned to the employee.
     */
    List<TicketDtoResponse> displayTopClosedTicketsByEmployee(String employeeName);
}
