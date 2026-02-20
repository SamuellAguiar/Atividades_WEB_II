package org.example.notifications.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.notifications.enums.EnumNotificationType;

@Entity
@Table(name = "tb_notifications")

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private UUID userId;

    private String service;
    private EnumNotificationType notificationType;

    private String subject;

    @Column(columnDefinition = "text")
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocalDateTime sentAt;
    private LocalDateTime readAt;

    @PrePersist
    public void beforeRegister(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void afterRegister(){
        this.updatedAt = LocalDateTime.now();
    }
}
