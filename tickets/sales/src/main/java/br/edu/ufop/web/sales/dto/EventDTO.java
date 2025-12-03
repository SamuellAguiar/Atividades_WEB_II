package br.edu.ufop.web.sales.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data // O Lombok cria getters, setters e toString automaticamente
public class EventDTO {
    private UUID id;
    private String description;
    private Integer type;
    private LocalDateTime date;
    private Double price;
    private LocalDateTime startSales;
    private LocalDateTime endSales;
}