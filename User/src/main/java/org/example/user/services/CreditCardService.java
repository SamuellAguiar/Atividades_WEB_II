package org.example.user.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.user.converters.CreditCardConverter;
import org.example.user.domain.CreditCardNetworkDomain;
import org.example.user.dtos.CreditCardNetwork.CreateCreditCardDTO;
import org.example.user.dtos.CreditCardNetwork.CreditCardDTO;
import org.example.user.dtos.CreditCardNetwork.UpdateCreditCard;
import org.example.user.models.CreditCardNetworkModel;
import org.example.user.repositories.ICreditCardNetworkRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CreditCardService {

    private final ICreditCardNetworkRepository creditCardNetworkRepository;

    // GET ALl
    public List<CreditCardDTO> getAllCreditCard(){
        List<CreditCardNetworkModel> creditCardNetworkModelList = creditCardNetworkRepository.findAll();

        return creditCardNetworkModelList.stream().map(CreditCardConverter::toCreditCardDTO).toList(); //* Procura por cada elemento | Acessa o static para converter cada elemento para DTO */
    }


    public CreditCardDTO getCreditCardNetworkByNumber() {

        CreditCardNetworkModel creditCardNetworkModel = new CreditCardNetworkModel(UUID.randomUUID(), "Visa");

        return CreditCardConverter.toCreditCardDTO(creditCardNetworkModel);
    }

    // CREATE credit card
    public CreditCardDTO createCreditCard(CreateCreditCardDTO createCreditCardNetworkDTO){
        CreditCardNetworkDomain domain = CreditCardConverter.toCreditCardNetworkDomain(createCreditCardNetworkDTO);

        CreditCardNetworkModel model = CreditCardConverter.toCreditCardNetworkModel(domain);

        return CreditCardConverter.toCreditCardDTO(creditCardNetworkRepository.save(model));
    }

    // GET by id
    public CreditCardDTO getCreditCardNetworkById(UUID id) {
        Optional<CreditCardNetworkModel>optionalCreditCardModel = creditCardNetworkRepository.findById(id); //* Conseguimos verificar se o item foi recuperado ou não */

        if (optionalCreditCardModel.isEmpty()){
            return null;
        }

        CreditCardNetworkModel creditCardModel = optionalCreditCardModel.get();
        return CreditCardConverter.toCreditCardDTO(creditCardModel);
    }

    // UPDATE credit card
    public CreditCardDTO updateCreditCard(UpdateCreditCard updateCreditCard){

        CreditCardNetworkDomain domainCCN = CreditCardConverter.toCreditCardNetworkDomain(updateCreditCard);

        Optional<CreditCardNetworkModel> optionalCCN = creditCardNetworkRepository.findById(updateCreditCard.id());

        if (optionalCCN.isEmpty()) {
            return null;
        }

        CreditCardNetworkModel modelCCN = CreditCardConverter.toCreditCardNetworkModel(domainCCN);

        return CreditCardConverter.toCreditCardDTO(creditCardNetworkRepository.save(modelCCN));
    }

}