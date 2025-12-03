package br.edu.ufop.web.sales.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateEventDTO {
    // Não precisa de ID, pois é criação
    private String description;
    private Integer type;
    private LocalDateTime date;
    private Double price;
    private LocalDateTime startSales;
    private LocalDateTime endSales;
}