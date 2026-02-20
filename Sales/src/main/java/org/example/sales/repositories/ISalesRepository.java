package org.example.sales.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.sales.models.SalesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalesRepository extends JpaRepository<SalesModel, UUID>{
    List<SalesModel> findAll();

    Optional<SalesModel> findById(UUID id);
}