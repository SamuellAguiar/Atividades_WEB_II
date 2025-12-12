package br.edu.ufop.web.sales.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CreateSaleDTO {
    private UUID eventId;
    private UUID userId;
}