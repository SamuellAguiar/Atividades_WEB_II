package br.edu.ufop.web.sales.controller;

import br.edu.ufop.web.sales.dto.CreateEventDTO;
import br.edu.ufop.web.sales.dto.EventDTO;
import br.edu.ufop.web.sales.dto.UpdateEventDTO;
import br.edu.ufop.web.sales.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Sales Service (Events) is running!");
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAll() {
        return ResponseEntity.ok(eventService.getAll());
    }

    @PostMapping
    public ResponseEntity<EventDTO> create(@RequestBody CreateEventDTO createEventDTO) {
        return ResponseEntity.ok(eventService.create(createEventDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getById(@PathVariable("id") UUID id) {
        Optional<EventDTO> eventDTO = eventService.getById(id);

        return eventDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/description/{text}")
    public ResponseEntity<List<EventDTO>> getByDescription(@PathVariable("text") String text) {
        List<EventDTO> list = eventService.getByDescription(text);

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @PutMapping
    public ResponseEntity<EventDTO> update(@RequestBody UpdateEventDTO updateEventDTO) {
        return ResponseEntity.ok(eventService.update(updateEventDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        eventService.delete(id);
        return ResponseEntity.ok().build();
    }
}