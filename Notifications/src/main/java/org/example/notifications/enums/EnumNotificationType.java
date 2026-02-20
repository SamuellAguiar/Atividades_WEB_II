package org.example.notifications.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumNotificationType {

    MESSAGE(0, "Message"),
    EMAIL(1, "E-mail");

    private int Id;
    private String Description;
}