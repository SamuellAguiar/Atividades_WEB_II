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
public class UpdateUserPasswordDTO {

    private UUID id;

    private String email;

    private String oldPassword;
    private String newPassword;
}
