package org.example.sales.repositories;

import java.util.List;
import java.util.UUID;

import org.example.sales.models.EventsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventsRepository extends JpaRepository<EventsModel, UUID>{
    List<EventsModel> findAll();
}
