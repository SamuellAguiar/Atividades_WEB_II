package org.example.user.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumUserType {
    // * Definir Cliente, Organizador e Administrador
    CUSTOMER(1, "Cliente"),
    ENTERPRISE(2, "Empresa"),
    ADMIN(3, "Administrador");

    private Integer id;
    private String description;
}