package br.edu.ufop.web.sales.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SaleDTO {
    private UUID id;

    // Na saída, retornamos o objeto Evento completo para facilitar o frontend
    private EventDTO event;

    private UUID userId;
    private LocalDateTime saleDate;
    private Integer saleStatus;
}