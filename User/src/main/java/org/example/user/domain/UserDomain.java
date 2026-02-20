package org.example.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.user.Enums.EnumUserType;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDomain {

    private UUID id;
    private String name;

    private String creditCardNumber;

    private String email;
    private String password;

    private String city;

    private CreditCardNetworkDomain creditCardNetworkDomain;

    private EnumUserType userType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}