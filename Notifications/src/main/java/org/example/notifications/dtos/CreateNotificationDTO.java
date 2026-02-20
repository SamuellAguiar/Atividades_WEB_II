package org.example.notifications.dtos;

import org.example.notifications.enums.EnumNotificationType;

import java.util.UUID;

public record CreateNotificationDTO(UUID userId, String service, EnumNotificationType notificationType, String subject, String content) {}
