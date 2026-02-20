package org.example.user.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.user.domain.CreditCardNetworkDomain;
import org.example.user.dtos.CreditCardNetwork.CreateCreditCardDTO;
import org.example.user.dtos.CreditCardNetwork.CreditCardDTO;
import org.example.user.dtos.CreditCardNetwork.UpdateCreditCard;
import org.example.user.models.CreditCardNetworkModel;

@NoArgsConstructor(access = AccessLevel.PRIVATE) //* Define uma classe sem contrutor */
public class CreditCardConverter {

    //* DTO para o modelo */
    public static CreditCardDTO toCreditCardDTO(CreditCardNetworkModel creditCardNetworkModel) {
        return new CreditCardDTO(creditCardNetworkModel.getId(), creditCardNetworkModel.getName());
    }

    //* DTO para o dominio */
    public static CreditCardNetworkDomain toCreditCardNetworkDomain(CreateCreditCardDTO createCreditCardNetworkDTO) {
        return CreditCardNetworkDomain.builder().name(createCreditCardNetworkDTO.getName()).build();
    }

    //* Modelo para Dominio */
    public static CreditCardNetworkModel toCreditCardNetworkModel(CreditCardNetworkDomain creditCardNetworkDomain) {
        return CreditCardNetworkModel.builder().id(creditCardNetworkDomain.getId()).name(creditCardNetworkDomain.getName()).build();
    }
    //* Para o metódo updateCreditCard */
    public static CreditCardNetworkDomain toCreditCardNetworkDomain(UpdateCreditCard updateCreditCard) {
        return CreditCardNetworkDomain.builder().name(updateCreditCard.name()).build();
    }
}