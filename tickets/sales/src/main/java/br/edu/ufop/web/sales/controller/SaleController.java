package br.edu.ufop.web.sales.controller;

import br.edu.ufop.web.sales.dto.CreateSaleDTO;
import br.edu.ufop.web.sales.dto.SaleDTO;
import br.edu.ufop.web.sales.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Sales Service (Sales) is running!");
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody CreateSaleDTO createSaleDTO) {
        return ResponseEntity.ok(saleService.create(createSaleDTO));
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable("id") UUID id) {
        Optional<SaleDTO> saleDTO = saleService.getById(id);

        return saleDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SaleDTO>> getByUserId(@PathVariable("userId") UUID userId) {
        List<SaleDTO> list = saleService.getByUserId(userId);
        return ResponseEntity.ok(list);
    }
}