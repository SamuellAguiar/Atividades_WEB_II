package br.edu.ufop.web.sales.converter;

import br.edu.ufop.web.sales.domain.EventDomain;
import br.edu.ufop.web.sales.dto.CreateEventDTO;
import br.edu.ufop.web.sales.dto.EventDTO;
import br.edu.ufop.web.sales.entity.EventEntity;

public class EventConverter {

    public static EventDTO toEventDTO(EventEntity entity) {
        EventDTO dto = new EventDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getType());
        dto.setDate(entity.getDate());
        dto.setPrice(entity.getPrice());
        dto.setStartSales(entity.getStartSales());
        dto.setEndSales(entity.getEndSales());
        return dto;
    }

    public static EventDomain toEventDomain(EventEntity entity) {
        EventDomain domain = new EventDomain();
        domain.setId(entity.getId());
        domain.setDescription(entity.getDescription());
        domain.setType(entity.getType());
        domain.setPrice(entity.getPrice());
        return domain;
    }

    public static EventDomain toEventDomain(CreateEventDTO dto) {
        EventDomain domain = new EventDomain();
        domain.setDescription(dto.getDescription());
        domain.setType(dto.getType());
        domain.setDate(dto.getDate());
        domain.setPrice(dto.getPrice());
        domain.setStartSales(dto.getStartSales());
        domain.setEndSales(dto.getEndSales());
        return domain;
    }

    public static EventEntity toEventEntity(EventDomain domain) {
        return EventEntity.builder()
                .id(domain.getId())
                .description(domain.getDescription())
                .type(domain.getType())
                .date(domain.getDate())
                .price(domain.getPrice())
                .startSales(domain.getStartSales())
                .endSales(domain.getEndSales())
                .build();
    }
}