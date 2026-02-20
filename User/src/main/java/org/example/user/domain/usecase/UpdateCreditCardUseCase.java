package org.example.user.domain.usecase;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class UpdateCreditCardUseCase {

    private UUID creditCardIdModel;
    private UUID creditCardIdPassed;
    private String creditCardNumberModel;
    private String creditCardNumberPassed;

    public void validate() {
        validateCreditCardId();
        validateCreditCardNumber();
    }

    private void validateCreditCardId() {
        if (!creditCardIdModel.equals(creditCardIdPassed)) {
            throw new RuntimeException("Invalid Credit Card ID");
        }
    }

    private void validateCreditCardNumber() {
        if (!creditCardNumberModel.equals(creditCardNumberPassed)) {
            throw new RuntimeException("Invalid Credit Card Number");
        }
    }
}
