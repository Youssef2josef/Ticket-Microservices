package com.stageb2m.ticketservice.repositories;

import com.stageb2m.ticketservice.models.PriorityLevel;
import com.stageb2m.ticketservice.models.Status;
import com.stageb2m.ticketservice.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    boolean existsBySerialNumber(String serialNumber);
    Ticket findByTitle(String title);
    List<Ticket> findByEmployeeName(String employeeName);
    List<Ticket> findByItSupportName(String itSupportName);
    List<Ticket> findByStatus(Status status);
    List<Ticket> findByPriority(PriorityLevel priority);
    List<Ticket> findByPriorityAndStatus(PriorityLevel priority, Status status);
    List<Ticket> findByPriorityAndStatusAndEmployeeName(PriorityLevel priority, Status status, String employeeName);
    List<Ticket> findByPriorityAndEmployeeName(PriorityLevel priority, String employeeName);

    @Query(value = """
            SELECT * FROM ticket_db 
            WHERE status = 'In_progress' 
            ORDER BY created_at DESC 
            LIMIT 10
            """, nativeQuery = true)
    List<Ticket> findTopInProgress();

    @Query(value = """
            SELECT * FROM ticket_db 
            WHERE status = 'Closed' 
            ORDER BY created_at DESC 
            LIMIT 40
            """, nativeQuery = true)
    List<Ticket> findTopClosed();

    @Query(value = """
            SELECT * FROM ticket_db
            WHERE status = 'In_progress' AND employee_name = :employeeName 
            ORDER BY created_at DESC 
            LIMIT 20
            """, nativeQuery = true)
    List<Ticket> findTopInProgressByEmployee(@Param("employeeName") String employeeName);

    @Query(value = """
            SELECT * FROM ticket_db
            WHERE status = 'Open' AND employee_name = :employeeName 
            ORDER BY created_at DESC 
            LIMIT 20
            """, nativeQuery = true)
    List<Ticket> findTopViewedByItSupportEmployee(@Param("employeeName") String employeeName);

    @Query(value = """
            SELECT * FROM ticket_db
            WHERE status = 'Closed' AND employee_name = :employeeName 
            ORDER BY created_at DESC 
            LIMIT 20
            """, nativeQuery = true)
    List<Ticket> findTopClosedEmployee(@Param("employeeName") String employeeName);


}
