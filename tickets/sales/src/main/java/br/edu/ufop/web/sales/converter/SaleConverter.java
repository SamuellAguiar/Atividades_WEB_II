package br.edu.ufop.web.sales.converter;

import br.edu.ufop.web.sales.domain.SaleDomain;
import br.edu.ufop.web.sales.dto.CreateSaleDTO;
import br.edu.ufop.web.sales.dto.SaleDTO;
import br.edu.ufop.web.sales.entity.SaleEntity;

public class SaleConverter {

    // 1. Entity -> DTO (Para mostrar na API)
    public static SaleDTO toSaleDTO(SaleEntity entity) {
        SaleDTO dto = new SaleDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setSaleDate(entity.getSaleDate());
        dto.setSaleStatus(entity.getSaleStatus());

        // A parte legal: Convertemos também o evento aninhado
        if (entity.getEvent() != null) {
            dto.setEvent(EventConverter.toEventDTO(entity.getEvent()));
        }

        return dto;
    }

    // 2. Entity -> Domain (Para usar nas regras)
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

    // 3. CreateDTO -> Domain (Entrada da API)
    public static SaleDomain toSaleDomain(CreateSaleDTO dto) {
        SaleDomain domain = new SaleDomain();
        // Note: O DTO só tem IDs. O Service vai buscar o objeto Evento completo depois.
        domain.setUserId(dto.getUserId());
        // domain.setEvent(...) será preenchido no Service
        return domain;
    }

    // 4. Domain -> Entity (Para salvar no Banco)
    public static SaleEntity toSaleEntity(SaleDomain domain) {
        return SaleEntity.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .saleDate(domain.getSaleDate())
                .saleStatus(domain.getSaleStatus())
                // O Service já deve ter preenchido o EventDomain antes de chamar aqui
                .event(EventConverter.toEventEntity(domain.getEvent()))
                .build();
    }
}