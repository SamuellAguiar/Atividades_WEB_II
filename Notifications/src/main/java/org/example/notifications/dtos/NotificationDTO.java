package org.example.notifications.dtos;

import org.example.notifications.enums.EnumNotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificationDTO(UUID id, UUID userId, String service, EnumNotificationType notificationType, String subject, String sontent, LocalDateTime sentAt, LocalDateTime readAt) {}
