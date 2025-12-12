package br.edu.ufop.web.sales.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;

    @Column(nullable = false)
    private UUID userId;

    private LocalDateTime saleDate;

    // Status: 1-Aberto, 2-Pago, 3-Cancelado
    private Integer saleStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String cancelReason;

    @Column(nullable = false)
    private Boolean active = false;

    @PrePersist
    public void beforeSave() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        if (this.saleDate == null) {
            this.saleDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}