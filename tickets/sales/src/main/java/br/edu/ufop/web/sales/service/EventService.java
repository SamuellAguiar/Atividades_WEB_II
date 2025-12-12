package br.edu.ufop.web.sales.service;

import br.edu.ufop.web.sales.converter.EventConverter;
import br.edu.ufop.web.sales.domain.EventDomain;
import br.edu.ufop.web.sales.domain.usecase.CreateEventUseCase;
import br.edu.ufop.web.sales.dto.CreateEventDTO;
import br.edu.ufop.web.sales.dto.EventDTO;
import br.edu.ufop.web.sales.dto.UpdateEventDTO;
import br.edu.ufop.web.sales.entity.EventEntity;
import br.edu.ufop.web.sales.exception.UseCaseException;
import br.edu.ufop.web.sales.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final IEventRepository repository;
    private final CreateEventUseCase useCase;

    // 1. Listar todos
    public List<EventDTO> getAll() {
        List<EventEntity> list = repository.findAll();
        return list.stream()
                .map(EventConverter::toEventDTO)
                .toList();
    }

    // 2. Criar Evento
    public EventDTO create(CreateEventDTO createEventDTO) {
        EventDomain eventDomain = EventConverter.toEventDomain(createEventDTO);

        useCase.setEventDomain(eventDomain);
        useCase.validate();

        EventEntity entity = repository.save(
                EventConverter.toEventEntity(eventDomain)
        );

        return EventConverter.toEventDTO(entity);
    }

    // 3. Buscar por ID
    public Optional<EventDTO> getById(UUID id) {
        Optional<EventEntity> entityOptional = repository.findById(id);

        if (entityOptional.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(EventConverter.toEventDTO(entityOptional.get()));
    }

    // 4. Buscar por Descrição
    public List<EventDTO> getByDescription(String description) {

        List<EventEntity> list = repository.findAllDescriptionLike(description);

        return list.stream()
                .map(EventConverter::toEventDTO)
                .toList();
    }

    // 5. Atualizar
    public EventDTO update(UpdateEventDTO updateDTO) {
        Optional<EventEntity> entityOptional = repository.findById(updateDTO.getId());

        if (entityOptional.isEmpty()) {
            throw new UseCaseException("Event ID not found.");
        }

        EventEntity entity = entityOptional.get();

        entity.setDescription(updateDTO.getDescription());
        entity.setPrice(updateDTO.getPrice());
        entity.setType(updateDTO.getType());
        entity.setDate(updateDTO.getDate());

        repository.save(entity);

        return EventConverter.toEventDTO(entity);
    }

    // 6. Deletar
    public void delete(UUID id) {
        Optional<EventEntity> entityOptional = repository.findById(id);

        if (entityOptional.isEmpty()) {
            throw new UseCaseException("Event ID not found.");
        }

        repository.delete(entityOptional.get());
    }
}