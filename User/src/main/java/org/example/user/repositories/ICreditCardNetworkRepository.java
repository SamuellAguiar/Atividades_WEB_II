package org.example.user.repositories;

import org.example.user.models.CreditCardNetworkModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ICreditCardNetworkRepository extends JpaRepository<CreditCardNetworkModel, UUID> {

    Optional<CreditCardNetworkModel> findById(UUID id);
    Optional<CreditCardNetworkModel> findByName(String name);

}