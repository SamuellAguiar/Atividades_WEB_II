package org.example.sales.Services;


import java.util.List;
import java.util.Optional;

import org.example.sales.converters.SalesConverter;
import org.example.sales.domain.SalesDomain;
import org.example.sales.dtos.CreateSaleDTO;
import org.example.sales.dtos.DeleteSaleDTO;
import org.example.sales.dtos.SimpleSalesRecordDTO;
import org.example.sales.dtos.UpdatePurchaseStatusDTO;
import org.example.sales.models.EventsModel;
import org.example.sales.models.SalesModel;
import org.example.sales.repositories.IEventsRepository;
import org.example.sales.repositories.ISalesRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SalesService {

    private final ISalesRepository salesRepository;
    private final IEventsRepository eventRepository;

    // GET
    public List<SimpleSalesRecordDTO> getAllSales() {
        List<SalesModel> salesList = salesRepository.findAll();

        return salesList.stream().map(SalesConverter::toSimpleSalesRecordDTO).toList();
    }

    // POST
    public SimpleSalesRecordDTO createSale(CreateSaleDTO createSaleDTO) {
        EventsModel event = eventRepository.findById(createSaleDTO.eventId()).orElseThrow(() -> new RuntimeException("Event not found"));

        SalesDomain domain = SalesConverter.toSalesDomain(createSaleDTO);
        SalesModel model = SalesConverter.toSalesModel(domain, event);

        return SalesConverter.toSimpleSalesRecordDTO(salesRepository.save(model));
    }

    // PUT
    public SimpleSalesRecordDTO updatePurchaseType(UpdatePurchaseStatusDTO updatePurchaseStatusDTO){
        EventsModel event = eventRepository.findById(updatePurchaseStatusDTO.eventId()).orElseThrow(() -> new RuntimeException("Oops... Something went wrong"));

        SalesDomain domain = SalesConverter.toSalesDomain(updatePurchaseStatusDTO);
        SalesModel model = SalesConverter.toSalesModel(domain, event);

        return SalesConverter.toSimpleSalesRecordDTO(salesRepository.save(model));
    }

    // DELETEA
    public void deleteSale(DeleteSaleDTO deleteSaleDTO){
        Optional<SalesModel> optional = salesRepository.findById(deleteSaleDTO.id());
        salesRepository.delete(optional.get());
    }
}
