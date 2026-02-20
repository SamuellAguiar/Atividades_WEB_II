package org.example.user.dtos;


import org.example.user.models.CreditCardNetworkModel;

import java.util.UUID;

public record UserRecordDTO(UUID id, String name, String email, CreditCardNetworkModel creditCardNetworkModel) {

}
