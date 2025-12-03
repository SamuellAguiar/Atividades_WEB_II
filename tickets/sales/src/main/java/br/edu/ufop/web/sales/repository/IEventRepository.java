package br.edu.ufop.web.sales.repository;

import br.edu.ufop.web.sales.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IEventRepository extends JpaRepository<EventEntity, UUID> {

    List<EventEntity> findByDescription(String description);

    List<EventEntity> findAllByDescriptionContainingIgnoreCase(String description);

    @Query(value = "SELECT * FROM tb_events e WHERE e.description LIKE %:description%", nativeQuery = true)
    List<EventEntity> findAllDescriptionLike(@Param("description") String description);

}