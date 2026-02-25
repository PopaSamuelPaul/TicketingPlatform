package com.camera42.ticket_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_orders")
@Data
@NoArgsConstructor
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Long eventId;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private LocalDateTime orderDate;
}
