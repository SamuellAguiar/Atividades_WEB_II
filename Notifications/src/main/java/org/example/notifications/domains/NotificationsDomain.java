package org.example.notifications.domains;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.notifications.enums.EnumNotificationType;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationsDomain {

    private UUID id;

    private UUID userId;

    private String service;
    private EnumNotificationType notificationType;

    private String subject;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocalDateTime sentAt;
    private LocalDateTime readAt;
}
