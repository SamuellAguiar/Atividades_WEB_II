package br.edu.ufop.web.sales.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CreateSaleDTO {
    // Quem compra manda apenas os IDs
    private UUID eventId;
    private UUID userId;
}