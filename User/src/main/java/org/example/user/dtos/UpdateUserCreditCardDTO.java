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

public class UpdateUserCreditCardDTO {

    private UUID id;

    private UUID creditCardId;
    private String creditCardNumber;
}
