package org.example.sales.dtos;

import java.util.UUID;

public record SimpleSalesRecordDTO(UUID id, UUID userId, UUID eventId, int purchaseStatus) {}