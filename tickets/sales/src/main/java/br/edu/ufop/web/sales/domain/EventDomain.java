package br.edu.ufop.web.sales.domain;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class EventDomain {
    private UUID id;
    private String description;
    private Integer type;
    private LocalDateTime date;
    private LocalDateTime startSales;
    private LocalDateTime endSales;
    private Double price;
}