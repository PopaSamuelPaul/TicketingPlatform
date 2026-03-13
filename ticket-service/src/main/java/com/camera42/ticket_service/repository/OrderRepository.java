package com.camera42.ticket_service.repository;

import com.camera42.ticket_service.model.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<TicketOrder,Long> {
}
