package org.example.sales.Services;


import java.util.List;
import java.util.Optional;

import org.example.sales.converters.EventsConverter;
import org.example.sales.domain.EventsDomain;
import org.example.sales.dtos.eventsDTOS.*;
import org.example.sales.models.EventsModel;
import org.example.sales.repositories.IEventsRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventsService {
    private final IEventsRepository eventsRepository;

    // GET all events
    public List<SimpleEventsRecordDTO> getAllEvents() {
        List<EventsModel> eventsList = eventsRepository.findAll();
        return eventsList.stream().map(EventsConverter::toSimpleEventsRecordDTO).toList();
    }

    // CREATE EVENT
    public SimpleEventsRecordDTO createEvent(CreateEventDTO eventDTO) {
        EventsDomain domain = EventsConverter.toEventsDomain(eventDTO);
        EventsModel model = EventsConverter.toEventsModel(domain);

        return EventsConverter.toSimpleEventsRecordDTO(eventsRepository.save(model));
    }

    // UPDATE PRICE
    public SimpleEventsRecordDTO updateEventPrice(UpdateEventPriceDTO updateEventPriceDTO) {

        Optional<EventsModel> optional = eventsRepository.findById(updateEventPriceDTO.id());

        if (optional.isEmpty()){
            return null;
        }

        EventsModel eventsModel = optional.get();
        eventsModel.setPrice(updateEventPriceDTO.price());

        return EventsConverter.toSimpleEventsRecordDTO(eventsRepository.save(eventsModel));
    }

    // UPDATE DATE
    public SimpleEventsRecordDTO updateEventDate(UpdateEventDateDTO updateEventDateDTO) {
        Optional<EventsModel> optional = eventsRepository.findById(updateEventDateDTO.id());

        if (optional.isEmpty()) {
            return null;
        }

        EventsModel eventsModel = optional.get();
        eventsModel.setDate(updateEventDateDTO.newDate());
        eventsModel.setStartSales(updateEventDateDTO.startSale());
        eventsModel.setEndSales(updateEventDateDTO.endSale());

        return EventsConverter.toSimpleEventsRecordDTO(eventsRepository.save(eventsModel));
    }

    // DELETE EVENT
    public void deleteEvent(DeleteEventDTO deleteEventDTO) {
        Optional<EventsModel> optional = eventsRepository.findById(deleteEventDTO.id());

        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Event not found with id: " + deleteEventDTO.id());
        }

        eventsRepository.delete(optional.get());
    }
}
