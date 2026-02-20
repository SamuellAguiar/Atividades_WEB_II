package org.example.notifications.services;

import lombok.AllArgsConstructor;
import org.example.notifications.converters.NotificationConverter;
import org.example.notifications.domains.NotificationsDomain;
import org.example.notifications.dtos.CreateNotificationDTO;
import org.example.notifications.dtos.NotificationDTO;
import org.example.notifications.models.NotificationModel;
import org.example.notifications.repositories.INotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {

    private final INotificationRepository notificationRepository;

    //GET
    public List<NotificationDTO> listAll(){
        List<NotificationModel> listNotification = notificationRepository.findAll();
        return listNotification.stream().map(NotificationConverter::toNotificationDTO).toList();
    }


    // CREATE
    public NotificationDTO create(CreateNotificationDTO createNotificationDTO){
        NotificationsDomain notificationsDomain = NotificationConverter.toNotificationDomain(createNotificationDTO);

        NotificationModel model = NotificationConverter.toNotificationModel(notificationsDomain);
        return NotificationConverter.toNotificationDTO(notificationRepository.save(model));
    }
}