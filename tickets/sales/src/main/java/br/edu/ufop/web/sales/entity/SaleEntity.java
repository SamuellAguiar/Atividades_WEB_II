package br.edu.ufop.web.sales.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_sales") // Prefixo tb_
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // Relacionamento: Muitas vendas pertencem a UM evento
    // O "nullable = false" obriga a venda a ter um evento vinculado
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;

    // Guardamos apenas o ID do usuário (pois ele vem do microsserviço Users)
    @Column(nullable = false)
    private UUID userId;

    private LocalDateTime saleDate;

    // Status: 1-Aberto, 2-Pago, 3-Cancelado
    private Integer saleStatus;

    // Auditoria
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Preenche datas automaticamente
    @PrePersist
    public void beforeSave() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

        // Se a data da venda não for passada, assume agora
        if (this.saleDate == null) {
            this.saleDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}