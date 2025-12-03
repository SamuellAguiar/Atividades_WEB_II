package br.edu.ufop.web.sales.domain;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SaleDomain {
    private UUID id;

    private EventDomain event;

    private UUID userId;
    private LocalDateTime saleDate;
    private Integer saleStatus;
}