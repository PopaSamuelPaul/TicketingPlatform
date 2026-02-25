package com.camera42.ticket_service.service;

import com.camera42.ticket_service.model.Event;
import com.camera42.ticket_service.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    public Event createEvent(Event event){
        event.setAvailableTickets(event.getTotalTickets());
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
}
