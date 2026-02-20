package org.example.sales.controllers;

import lombok.AllArgsConstructor;
import org.example.sales.Services.SalesService;
import org.example.sales.Services.client.UserServiceClient;
import org.example.sales.dtos.CreateSaleDTO;
import org.example.sales.dtos.DeleteSaleDTO;
import org.example.sales.dtos.SimpleSalesRecordDTO;
import org.example.sales.dtos.UpdatePurchaseStatusDTO;
import org.example.sales.dtos.externals.users.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;
    private final UserServiceClient userServiceClient;

    @GetMapping("/status")
    public ResponseEntity<String> serviceStatus(){
        return ResponseEntity.ok("[STATUS] Sales Service is running");
    }

    //* GET all sales
    @GetMapping("/list-sales")
    public ResponseEntity<List<SimpleSalesRecordDTO>> getAllSales(){
        List<SimpleSalesRecordDTO> salesList = salesService.getAllSales();
        return ResponseEntity.ok(salesList);
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userList = userServiceClient.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    //* CREATE sale */
    @PostMapping
    public ResponseEntity<SimpleSalesRecordDTO> createSale(@RequestBody CreateSaleDTO createSaleDTO) {
        SimpleSalesRecordDTO createdSale = salesService.createSale(createSaleDTO);
        return ResponseEntity.ok(createdSale);
    }

    //* UPDATE purchaseStatus */
    @PutMapping("/purchase-status")
    public ResponseEntity<SimpleSalesRecordDTO> updatePurchaseType(@RequestBody UpdatePurchaseStatusDTO updatePurchaseStatusDTO){
        SimpleSalesRecordDTO updatePurchase = salesService.updatePurchaseType(updatePurchaseStatusDTO);
        return ResponseEntity.ok(updatePurchase);
    }

    //* DELETE sale */
    @DeleteMapping("/remove-sale")
    public ResponseEntity<Object> deleteSale(@RequestBody DeleteSaleDTO deleteSaleDTO){
        salesService.deleteSale(deleteSaleDTO);
        return ResponseEntity.ok("Sale has been deleted");
    }
}
