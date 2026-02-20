package org.example.sales.domain;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class EventsDomain {
    private UUID id;

    private String description;

    private int type;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startSales;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endSales;

    private float price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}