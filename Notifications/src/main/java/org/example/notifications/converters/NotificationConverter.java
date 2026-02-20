package org.example.notifications.converters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.notifications.domains.NotificationsDomain;
import org.example.notifications.dtos.CreateNotificationDTO;
import org.example.notifications.dtos.NotificationDTO;
import org.example.notifications.models.NotificationModel;

@NoArgsConstructor
@Getter
@Setter
public class NotificationConverter {

    public static NotificationDTO toNotificationDTO(NotificationModel notificationModel){
        return new NotificationDTO(notificationModel.getId(), notificationModel.getUserId(), notificationModel.getService(), notificationModel.getNotificationType(), notificationModel.getSubject(), notificationModel.getContent(), notificationModel.getSentAt(), notificationModel.getReadAt());
    }

    public static NotificationModel toNotificationModel(NotificationsDomain notificationsDomain){
        return NotificationModel.builder().id(notificationsDomain.getId()).userId(notificationsDomain.getUserId()).service(notificationsDomain.getService()).notificationType(notificationsDomain.getNotificationType()).subject(notificationsDomain.getSubject()).content(notificationsDomain.getContent()).sentAt(notificationsDomain.getSentAt()).createdAt(notificationsDomain.getCreatedAt()).build();
    }

    public static NotificationModel toNotificationModel(CreateNotificationDTO createNotificationDTO){
        return NotificationModel.builder().userId(createNotificationDTO.userId()).service(createNotificationDTO.service()).notificationType(createNotificationDTO.notificationType()).subject(createNotificationDTO.subject()).content(createNotificationDTO.content()).build();
    }

    public static NotificationsDomain toNotificationDomain(CreateNotificationDTO createNotificationDTO){
        return NotificationsDomain.builder().userId(createNotificationDTO.userId()).service(createNotificationDTO.service()).notificationType(createNotificationDTO.notificationType()).subject(createNotificationDTO.subject()).content(createNotificationDTO.content()).build();
    }
}
