package br.edu.ufop.web.sales.repository;

import br.edu.ufop.web.sales.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ISaleRepository extends JpaRepository<SaleEntity, UUID> {

    // Método extra útil: Buscar todas as vendas de um usuário específico
    List<SaleEntity> findAllByUserId(UUID userId);

    // Método extra útil: Buscar todas as vendas de um evento específico
    List<SaleEntity> findAllByEventId(UUID eventId);

}