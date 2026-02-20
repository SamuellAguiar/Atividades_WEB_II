package org.example.sales.dtos.eventsDTOS;

import java.sql.Date;
import java.util.UUID;

public record UpdateEventDateDTO (UUID id, Date newDate, Date startSale, Date endSale) {}
