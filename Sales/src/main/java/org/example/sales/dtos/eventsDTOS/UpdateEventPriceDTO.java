package org.example.sales.dtos.eventsDTOS;

import java.util.UUID;

public record UpdateEventPriceDTO(UUID id, float price) {}