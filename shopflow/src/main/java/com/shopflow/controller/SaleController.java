package com.shopflow.controller;

import com.shopflow.controller.common.PaginatedResponse;
import com.shopflow.domain.model.Sale;
import com.shopflow.domain.usecase.common.FindAllUseCase;
import com.shopflow.domain.usecase.sale.CreateSaleUseCase;
import com.shopflow.domain.usecase.sale.DeleteByIdUseCase;
import com.shopflow.domain.usecase.sale.FindByIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SaleController.URL)
@CrossOrigin(origins = "http://localhost:4200")
public class SaleController {
    public static final String URL = "/api/sales";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    @Autowired
    private CreateSaleUseCase createSaleUseCase;
    @Autowired
    private FindAllUseCase<Sale> findAllSaleUseCase;
    @Autowired
    private FindByIdUseCase findByIdUseCase;
    @Autowired
    private DeleteByIdUseCase deleteByIdUseCase;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Sale sale) {
        createSaleUseCase.create(sale);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PaginatedResponse<Sale>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);

        List<Sale> saleList = findAllSaleUseCase.findAll();

        PaginatedResponse<Sale> response = new PaginatedResponse<>(saleList, saleList.size(), page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Integer id) {
        Sale sale = findByIdUseCase.findById(id);
        if (sale != null) {
            return new ResponseEntity<>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deleteByIdUseCase.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
