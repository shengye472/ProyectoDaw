package com.shopflow.controller;

import com.shopflow.controller.common.PaginatedResponse;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.usecase.FindAllUseCase;
import com.shopflow.domain.usecase.FindByBarCodeUseCase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProductController.URL)
public class  ProductController {
    public static final String URL = "/api/products";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final FindAllUseCase findAllUseCase;
    private final FindByBarCodeUseCase findByBarCodeUseCase;

    public ProductController(FindAllUseCase findAllUseCase, FindByBarCodeUseCase findByBarCodeUseCase) {
        this.findAllUseCase = findAllUseCase;
        this.findByBarCodeUseCase = findByBarCodeUseCase;
    }

    @GetMapping
    public ResponseEntity<PaginatedResponse<Product>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);

        List<Product> productList = findAllUseCase.findAll();

        PaginatedResponse<Product> response = new PaginatedResponse<>(productList, productList.size(), page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
//    public ResponseEntity<List<Product>> findAll() {
//        List<Product> productList = findAllUseCase.findAll();
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }

    @GetMapping("/{barCode}")
    public ResponseEntity <Product> findByCodeBar(@PathVariable String barCode) {
        Product product = findByBarCodeUseCase.findByBarCode(barCode);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
