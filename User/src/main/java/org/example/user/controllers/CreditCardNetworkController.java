package org.example.user.controllers;

import java.util.List;

import org.example.user.dtos.CreditCardNetwork.CreateCreditCardDTO;
import org.example.user.dtos.CreditCardNetwork.CreditCardDTO;
import org.example.user.services.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/cc_network")
@AllArgsConstructor
public class CreditCardNetworkController {

    private final CreditCardService creditCardService;

    @GetMapping
    public ResponseEntity<List<CreditCardDTO>> getAll() {
        return ResponseEntity.ok(creditCardService.getAllCreditCard());
    }

    @PostMapping
    public ResponseEntity<CreditCardDTO> createCreditCard(@RequestBody CreateCreditCardDTO CreateCreditCardNetworkDTO){

        CreditCardDTO creditCardDTO = creditCardService.createCreditCard(CreateCreditCardNetworkDTO);

        if (creditCardDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(creditCardDTO);
    }
}