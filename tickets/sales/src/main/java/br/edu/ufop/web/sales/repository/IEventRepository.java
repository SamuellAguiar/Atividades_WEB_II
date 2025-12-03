package br.edu.ufop.web.sales.repository;

import br.edu.ufop.web.sales.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IEventRepository extends JpaRepository<EventEntity, UUID> {

    // 1. Busca exata pela descrição (Igual ao findByName do professor)
    // O Spring cria o SQL sozinho baseado no nome do método
    List<EventEntity> findByDescription(String description);

    // 2. Busca parcial (LIKE) ignorando maiúsculas/minúsculas
    // Ex: Se pesquisar "rock", acha "Show de Rock" e "Rock in Rio"
    List<EventEntity> findAllByDescriptionContainingIgnoreCase(String description);

    // 3. Query Nativa (SQL Puro) - Igual ao exemplo do professor
    // Note que mudamos de tb_users para tb_events
    @Query(value = "SELECT * FROM tb_events e WHERE e.description LIKE %:description%", nativeQuery = true)
    List<EventEntity> findAllDescriptionLike(@Param("description") String description);

}