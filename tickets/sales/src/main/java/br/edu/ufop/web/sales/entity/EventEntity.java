package br.edu.ufop.web.sales.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_events")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer type; // Tipo do evento (1=Show, 2=Teatro, etc.)

    private LocalDateTime date;       // Data do evento
    private LocalDateTime startSales; // Início das vendas
    private LocalDateTime endSales;   // Fim das vendas

    private Double price;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Executado automaticamente ANTES de salvar no banco
    @PrePersist
    public void beforeSave() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Executado automaticamente ANTES de atualizar
    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}