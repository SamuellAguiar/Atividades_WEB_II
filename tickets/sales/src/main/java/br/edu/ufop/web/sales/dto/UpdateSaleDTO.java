package br.edu.ufop.web.sales.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UpdateSaleDTO {
    private UUID id;
    private Integer saleStatus;
    private LocalDateTime saleDate;
}