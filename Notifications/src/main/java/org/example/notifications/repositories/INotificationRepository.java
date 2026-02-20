package org.example.notifications.repositories;


import org.example.notifications.models.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface INotificationRepository extends JpaRepository<NotificationModel, UUID> {

    List<NotificationModel> findAllByuserId(UUID userId);

}
