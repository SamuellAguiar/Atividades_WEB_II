package br.edu.ufop.web.sales.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class DeleteSaleDTO {
    private UUID id;
    private String reason;
}