package br.edu.ufop.web.sales.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UpdateSaleDTO {
    private UUID id;            // ID da venda que será atualizada
    private Integer saleStatus; // Novo Status
    private LocalDateTime saleDate; // Caso precise corrigir a data
}