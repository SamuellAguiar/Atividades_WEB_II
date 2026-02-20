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
public class CreateUserDTO {

    private String name;

    private String creditCardNumber;
    private UUID creditCardNetworkID;

    private String email;
    private String password;

    private String city;
}
