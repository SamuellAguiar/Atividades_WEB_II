package br.edu.ufop.web.sales.service;

import br.edu.ufop.web.sales.converter.EventConverter;
import br.edu.ufop.web.sales.converter.SaleConverter;
import br.edu.ufop.web.sales.domain.SaleDomain;
import br.edu.ufop.web.sales.domain.usecase.CreateSaleUseCase;
import br.edu.ufop.web.sales.dto.CreateSaleDTO;
import br.edu.ufop.web.sales.dto.DeleteSaleDTO;
import br.edu.ufop.web.sales.dto.SaleDTO;
import br.edu.ufop.web.sales.dto.UpdateSaleDTO; // Importe o DTO novo
import br.edu.ufop.web.sales.entity.EventEntity;
import br.edu.ufop.web.sales.entity.SaleEntity;
import br.edu.ufop.web.sales.exception.UseCaseException;
import br.edu.ufop.web.sales.repository.IEventRepository;
import br.edu.ufop.web.sales.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final ISaleRepository saleRepository;
    private final IEventRepository eventRepository;
    private final CreateSaleUseCase createSaleUseCase;

    // 1. Criar Venda
    public SaleDTO create(CreateSaleDTO createDTO) {
        SaleDomain saleDomain = SaleConverter.toSaleDomain(createDTO);

        Optional<EventEntity> eventOptional = eventRepository.findById(createDTO.getEventId());

        if (eventOptional.isEmpty()) {
            throw new UseCaseException("Event not found with ID: " + createDTO.getEventId());
        }

        saleDomain.setEvent(EventConverter.toEventDomain(eventOptional.get()));
        saleDomain.setSaleStatus(1); // 1 = Aberto

        createSaleUseCase.setSaleDomain(saleDomain);
        createSaleUseCase.validate();

        SaleEntity entity = saleRepository.save(
                SaleConverter.toSaleEntity(saleDomain)
        );

        return SaleConverter.toSaleDTO(entity);
    }

    // 2. Listar todas (O Hibernate vai filtrar active=true automaticamente)
    public List<SaleDTO> getAll() {
        return saleRepository.findAll().stream()
                .map(SaleConverter::toSaleDTO)
                .toList();
    }

    // 3. Buscar por ID
    public Optional<SaleDTO> getById(UUID id) {
        return saleRepository.findById(id)
                .map(SaleConverter::toSaleDTO);
    }

    // 4. Listar vendas de um usuário
    public List<SaleDTO> getByUserId(UUID userId) {
        return saleRepository.findAllByUserId(userId).stream()
                .map(SaleConverter::toSaleDTO)
                .toList();
    }

    // --- NOVOS MÉTODOS ---

    // 5. Atualizar Venda
    public SaleDTO update(UpdateSaleDTO updateDTO) {
        // Verifica se existe
        Optional<SaleEntity> entityOptional = saleRepository.findById(updateDTO.getId());

        if (entityOptional.isEmpty()) {
            throw new UseCaseException("Sale ID not found.");
        }

        SaleEntity entity = entityOptional.get();

        // Atualiza apenas se o valor foi enviado (não nulo)
        if (updateDTO.getSaleStatus() != null) {
            entity.setSaleStatus(updateDTO.getSaleStatus());
        }
        if (updateDTO.getSaleDate() != null) {
            entity.setSaleDate(updateDTO.getSaleDate());
        }

        // Salva as alterações
        saleRepository.save(entity);

        return SaleConverter.toSaleDTO(entity);
    }

    // 6. Soft Delete com Motivo Obrigatório
    public void delete(DeleteSaleDTO deleteDTO) {
        // 1. Validação: O motivo é obrigatório!
        if (deleteDTO.getReason() == null || deleteDTO.getReason().trim().isEmpty()) {
            throw new UseCaseException("Cancellation reason is required.");
        }

        // 2. Busca a venda
        Optional<SaleEntity> entityOptional = saleRepository.findById(deleteDTO.getId());

        if (entityOptional.isEmpty()) {
            throw new UseCaseException("Sale ID not found.");
        }

        SaleEntity entity = entityOptional.get();

        // 3. Salva o motivo do cancelamento ANTES de deletar
        // Precisamos salvar explicitamente, pois o @SQLDelete só atualiza o campo 'active'
        entity.setCancelReason(deleteDTO.getReason());
        saleRepository.save(entity);

        // 4. Executa o Soft Delete (active = false)
        saleRepository.delete(entity);
    }
}