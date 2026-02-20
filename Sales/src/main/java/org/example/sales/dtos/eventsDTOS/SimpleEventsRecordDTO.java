package org.example.sales.dtos.eventsDTOS;

import java.sql.Date;
import java.util.UUID;

public record SimpleEventsRecordDTO(UUID id, String description, int type, float price, Date date, Date startSales, Date endSales) {}