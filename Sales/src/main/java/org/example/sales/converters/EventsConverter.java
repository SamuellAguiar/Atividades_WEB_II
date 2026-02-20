package org.example.sales.converters;


import org.example.sales.domain.EventsDomain;
import org.example.sales.dtos.eventsDTOS.CreateEventDTO;
import org.example.sales.dtos.eventsDTOS.SimpleEventsRecordDTO;
import org.example.sales.dtos.eventsDTOS.UpdateEventDateDTO;
import org.example.sales.dtos.eventsDTOS.UpdateEventPriceDTO;
import org.example.sales.models.EventsModel;

public class EventsConverter {

    public static SimpleEventsRecordDTO toSimpleEventsRecordDTO(EventsModel eventsModel) {
        return new SimpleEventsRecordDTO(eventsModel.getId(),eventsModel.getDescription(),eventsModel.getType(),eventsModel.getPrice(),eventsModel.getDate(),eventsModel.getStartSales(),eventsModel.getEndSales());
    }

    public static EventsModel toEventsModel(EventsDomain eventsDomain) {
        return EventsModel.builder().id(eventsDomain.getId()).description(eventsDomain.getDescription()).type(eventsDomain.getType()).price(eventsDomain.getPrice()).date(eventsDomain.getDate()).startSales(eventsDomain.getStartSales()).endSales(eventsDomain.getEndSales()).build();
    }

    public static EventsDomain toEventsDomain(CreateEventDTO createEventDTO) {
        return EventsDomain.builder().description(createEventDTO.description()).type(createEventDTO.type()).price(createEventDTO.price()).date(createEventDTO.date()).startSales(createEventDTO.startSales()).endSales(createEventDTO.endSales()).build();
    }

    public static EventsDomain toEventsDomain(SimpleEventsRecordDTO simpleEventsRecordDTO) {
        return EventsDomain.builder().id(simpleEventsRecordDTO.id()).description(simpleEventsRecordDTO.description()).type(simpleEventsRecordDTO.type()).price(simpleEventsRecordDTO.price()).build();
    }

    public static EventsDomain toEventsDomain(UpdateEventPriceDTO updateEventPriceDTO) {
        return EventsDomain.builder().id(updateEventPriceDTO.id()).price(updateEventPriceDTO.price()).build();
    }

    public static EventsDomain toEventsDomain(UpdateEventDateDTO updateEventDateDTO) {
        return EventsDomain.builder().id(updateEventDateDTO.id()).date(updateEventDateDTO.newDate()).startSales(updateEventDateDTO.startSale()).endSales(updateEventDateDTO.endSale()).build();
    }
}