package org.example.sales.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_events")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class EventsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, columnDefinition = "varchar(100)")
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