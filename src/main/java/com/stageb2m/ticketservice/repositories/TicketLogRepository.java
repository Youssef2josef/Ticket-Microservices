package com.stageb2m.ticketservice.repositories;

import com.stageb2m.ticketservice.models.TicketLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketLogRepository extends JpaRepository<TicketLog, Long> {
}
