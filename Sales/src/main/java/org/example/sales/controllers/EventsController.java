package org.example.sales.controllers;


import java.util.List;

import org.example.sales.Services.EventsService;
import org.example.sales.dtos.eventsDTOS.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventsService;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Events Service is running");
    }

    // List all events
    @GetMapping("list-events")
    public ResponseEntity<List<SimpleEventsRecordDTO>> getAllEvents() {
        List<SimpleEventsRecordDTO> eventsList = eventsService.getAllEvents();
        return ResponseEntity.ok(eventsList);
    }

    @PostMapping
    public ResponseEntity<SimpleEventsRecordDTO> createEvent(@RequestBody CreateEventDTO createEventDTO) {
        SimpleEventsRecordDTO eventRecord = eventsService.createEvent(createEventDTO);
        return ResponseEntity.ok(eventRecord);
    }

    @PutMapping("/new-price")
    public ResponseEntity<SimpleEventsRecordDTO> updateEventPrice(@RequestBody UpdateEventPriceDTO updateEventPriceDTO) {
        SimpleEventsRecordDTO updatedEvent = eventsService.updateEventPrice(updateEventPriceDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    @PutMapping("/new-date")
    public ResponseEntity<SimpleEventsRecordDTO> updateEventDate(@RequestBody UpdateEventDateDTO updateEventDateDTO) {
        SimpleEventsRecordDTO updatedEvent = eventsService.updateEventDate(updateEventDateDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/exclude-event")
    public ResponseEntity<Object> deleteEvent(@RequestBody DeleteEventDTO deleteEventDTO) {
        eventsService.deleteEvent(deleteEventDTO);
        return ResponseEntity.ok("Event canceled");
    }
}