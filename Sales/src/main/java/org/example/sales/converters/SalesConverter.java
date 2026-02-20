package org.example.sales.converters;

import org.example.sales.domain.SalesDomain;
import org.example.sales.dtos.CreateSaleDTO;
import org.example.sales.dtos.SimpleSalesRecordDTO;
import org.example.sales.dtos.UpdatePurchaseStatusDTO;
import org.example.sales.models.EventsModel;
import org.example.sales.models.SalesModel;

public class SalesConverter {

    public static SimpleSalesRecordDTO toSimpleSalesRecordDTO(SalesModel salesModel){
        return new SimpleSalesRecordDTO(salesModel.getId(), salesModel.getUserId(), salesModel.getEventModel().getId(), salesModel.getPurchaseStatus());
    }

    public static SalesDomain toSalesDomain(SimpleSalesRecordDTO simpleSalesRecordDTO) {
        return SalesDomain.builder().id(simpleSalesRecordDTO.id()).userId(simpleSalesRecordDTO.userId()).eventId(simpleSalesRecordDTO.eventId()).purchaseStatus(simpleSalesRecordDTO.purchaseStatus()).build();
    }

    public static SalesModel toSalesModel(SalesDomain salesDomain, EventsModel event) {
        return SalesModel.builder().id(salesDomain.getId()).userId(salesDomain.getUserId()).eventModel(event).purchaseDate(salesDomain.getPurchaseDate()).purchaseStatus(salesDomain.getPurchaseStatus()).build(); //? REVIEW THIS LINE
    }

    public static SalesDomain toSalesDomain(CreateSaleDTO createSaleDTO) {
        return SalesDomain.builder().eventId(createSaleDTO.eventId()).userId(createSaleDTO.userId()).purchaseStatus(createSaleDTO.purchaseStatus()).build();
    }

    public static SalesDomain toSalesDomain(UpdatePurchaseStatusDTO updatePurchaseStatusDTO){
        return SalesDomain.builder().id(updatePurchaseStatusDTO.id()).userId(updatePurchaseStatusDTO.userId()).eventId(updatePurchaseStatusDTO.eventId()).purchaseStatus(updatePurchaseStatusDTO.purchaseStatus()).build();
    }
}
