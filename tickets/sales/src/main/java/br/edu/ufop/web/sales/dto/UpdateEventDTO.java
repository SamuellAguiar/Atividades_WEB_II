package br.edu.ufop.web.sales.dto;

import lombok.Data;
import java.util.UUID;
import java.time.LocalDateTime;

@Data
public class UpdateEventDTO {
    private UUID id; // Obrigatório para saber qual evento atualizar
    private String description;
    private Integer type;
    private LocalDateTime date;
    private Double price;
    private LocalDateTime startSales;
    private LocalDateTime endSales;
}