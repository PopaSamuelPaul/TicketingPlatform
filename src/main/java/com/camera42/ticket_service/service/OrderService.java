package com.camera42.ticket_service.service;

import com.camera42.ticket_service.model.Event;
import com.camera42.ticket_service.model.TicketOrder;
import com.camera42.ticket_service.repository.EventRepository;
import com.camera42.ticket_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final EventRepository eventRepository;

    public TicketOrder createOrder(String email, Long eventId){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Evenimentul nu a fost găsit!"));

        if(event.getAvailableTickets() <= 0){
            throw new RuntimeException("Nu mai sunt bilete disponibile!");
        }
        event.setAvailableTickets(event.getAvailableTickets() - 1);
        eventRepository.save(event);
        TicketOrder newOrder = new TicketOrder();
        newOrder.setOrderDate(LocalDateTime.now());
        newOrder.setUserEmail(email);
        newOrder.setEventId(eventId);

        return orderRepository.save(newOrder);
    }
}
