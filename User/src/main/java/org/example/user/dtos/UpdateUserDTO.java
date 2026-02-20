package org.example.user.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {

    private UUID id;

    private String name;

    private UUID creditCardId;
    private String creditCardNumber;

    private String email;
    private String password;
    private String city;
}
