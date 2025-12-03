package br.edu.ufop.web.sales.service;

import br.edu.ufop.web.sales.converter.EventConverter;
import br.edu.ufop.web.sales.converter.SaleConverter;
import br.edu.ufop.web.sales.domain.SaleDomain;
import br.edu.ufop.web.sales.domain.usecase.CreateSaleUseCase;
import br.edu.ufop.web.sales.dto.CreateSaleDTO;
import br.edu.ufop.web.sales.dto.SaleDTO;
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
        // Converte o básico (IDs)
        SaleDomain saleDomain = SaleConverter.toSaleDomain(createDTO);

        // BUSCAR O EVENTO NO BANCO
        Optional<EventEntity> eventOptional = eventRepository.findById(createDTO.getEventId());

        if (eventOptional.isEmpty()) {
            throw new UseCaseException("Event not found with ID: " + createDTO.getEventId());
        }

        // Vincula o evento encontrado ao domínio da venda
        saleDomain.setEvent(EventConverter.toEventDomain(eventOptional.get()));

        // Define status inicial (1 = Aberto/Pendente)
        saleDomain.setSaleStatus(1);

        // Valida regras
        createSaleUseCase.setSaleDomain(saleDomain);
        createSaleUseCase.validate();

        // Salva
        SaleEntity entity = saleRepository.save(
                SaleConverter.toSaleEntity(saleDomain)
        );

        return SaleConverter.toSaleDTO(entity);
    }

    // 2. Listar todas
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

    // 4. Listar vendas de um usuário (Extra)
    public List<SaleDTO> getByUserId(UUID userId) {
        return saleRepository.findAllByUserId(userId).stream()
                .map(SaleConverter::toSaleDTO)
                .toList();
    }
}