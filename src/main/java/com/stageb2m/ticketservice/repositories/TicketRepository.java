package com.stageb2m.ticketservice.repositories;

import com.stageb2m.ticketservice.models.PriorityLevel;
import com.stageb2m.ticketservice.models.Status;
import com.stageb2m.ticketservice.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    // Additional query methods can be defined here if needed
    boolean existsBySerialNumber(String serialNumber);
    Ticket findByTitle(String title);
    List<Ticket> findByEmployeeName(String employeeName);
    List<Ticket> findByItSupportName(String itSupportName);
    List<Ticket> findAll(String itSupportEmail);
    Ticket findByEmployeeNameAndItSupportName(String employeeName, String itSupportName);
    List<Ticket> findByStatus(Status status);
    List<Ticket> findByPriority(PriorityLevel priority);
    List<Ticket> findByPriorityAndStatus(PriorityLevel priority, Status status);
    List<Ticket> findByPriorityAndStatusAndEmployeeName(PriorityLevel priority, Status status, String employeeName);
    List<Ticket> findByPriorityAndEmployeeName(PriorityLevel priority, String employeeName);


}
