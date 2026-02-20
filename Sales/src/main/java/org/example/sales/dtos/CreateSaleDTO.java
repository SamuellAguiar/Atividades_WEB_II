package org.example.sales.dtos;

import java.util.UUID;

public record CreateSaleDTO(UUID eventId, UUID userId, int purchaseStatus) {}
