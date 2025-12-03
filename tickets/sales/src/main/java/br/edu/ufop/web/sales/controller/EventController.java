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
@RequestMapping("/events") // Define a URL base: http://localhost:4000/events
@RequiredArgsConstructor // Injeta o Service automaticamente (igual ao do professor)
public class EventController {

    private final EventService eventService;

    // Teste de fumaça (para saber se o serviço está no ar)
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Sales Service (Events) is running!");
    }

    // 1. Listar todos
    @GetMapping
    public ResponseEntity<List<EventDTO>> getAll() {
        return ResponseEntity.ok(eventService.getAll());
    }

    // 2. Criar novo evento
    @PostMapping
    public ResponseEntity<EventDTO> create(@RequestBody CreateEventDTO createEventDTO) {
        return ResponseEntity.ok(eventService.create(createEventDTO));
    }

    // 3. Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getById(@PathVariable("id") UUID id) {
        Optional<EventDTO> eventDTO = eventService.getById(id);

        // Se estiver vazio, retorna 404 (Not Found). Se achar, retorna 200 (OK)
        return eventDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Buscar por Descrição (Igual ao getByName do professor)
    @GetMapping("/description/{text}")
    public ResponseEntity<List<EventDTO>> getByDescription(@PathVariable("text") String text) {
        List<EventDTO> list = eventService.getByDescription(text);

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    // 5. Atualizar
    @PutMapping
    public ResponseEntity<EventDTO> update(@RequestBody UpdateEventDTO updateEventDTO) {
        return ResponseEntity.ok(eventService.update(updateEventDTO));
    }

    // 6. Deletar
    // Diferente do usuário (que pedia senha), aqui deletamos direto pelo ID na URL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        eventService.delete(id);
        return ResponseEntity.ok().build();
    }
}