package br.edu.ufop.web.sales.converter;

import br.edu.ufop.web.sales.domain.SaleDomain;
import br.edu.ufop.web.sales.dto.CreateSaleDTO;
import br.edu.ufop.web.sales.dto.SaleDTO;
import br.edu.ufop.web.sales.entity.SaleEntity;

public class SaleConverter {

    public static SaleDTO toSaleDTO(SaleEntity entity) {
        SaleDTO dto = new SaleDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setSaleDate(entity.getSaleDate());
        dto.setSaleStatus(entity.getSaleStatus());

        if (entity.getEvent() != null) {
            dto.setEvent(EventConverter.toEventDTO(entity.getEvent()));
        }

        return dto;
    }

    public static SaleDomain toSaleDomain(SaleEntity entity) {
        SaleDomain domain = new SaleDomain();
        domain.setId(entity.getId());
        domain.setUserId(entity.getUserId());
        domain.setSaleDate(entity.getSaleDate());
        domain.setSaleStatus(entity.getSaleStatus());

        if (entity.getEvent() != null) {
            domain.setEvent(EventConverter.toEventDomain(entity.getEvent()));
        }

        return domain;
    }

    public static SaleDomain toSaleDomain(CreateSaleDTO dto) {
        SaleDomain domain = new SaleDomain();
        domain.setUserId(dto.getUserId());

        return domain;
    }

    public static SaleEntity toSaleEntity(SaleDomain domain) {
        return SaleEntity.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .saleDate(domain.getSaleDate())
                .saleStatus(domain.getSaleStatus())
                .event(EventConverter.toEventEntity(domain.getEvent()))
                .build();
    }
}