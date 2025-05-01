package com.shopflow.controller;

import com.shopflow.controller.common.PaginatedResponse;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.usecase.*;
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

    private final FindAllUseCase<Product> findAllUseCase;
    private final FindByUseCase<Product> findByCodeBarUseCase;
    private final CreateUseCase<Product> createUseCase;
    private final DeleteByUseCase<Product> deleteByCodeBarUseCase;
    private final EditByUseCase<Product> editByCodeBarUseCase;

    public ProductController(FindAllUseCase<Product> findAllUseCase, FindByUseCase<Product> findByCodeBarUseCase, CreateUseCase<Product> createUseCase, DeleteByUseCase<Product> deleteByCodeBarUseCase, EditByUseCase<Product> editByCodeBarUseCase) {
        this.findAllUseCase = findAllUseCase;
        this.findByCodeBarUseCase = findByCodeBarUseCase;
        this.createUseCase = createUseCase;
        this.deleteByCodeBarUseCase = deleteByCodeBarUseCase;
        this.editByCodeBarUseCase = editByCodeBarUseCase;
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

    @GetMapping("/{codeBar}")
    public ResponseEntity <Product> findByCodeBar(@PathVariable String codeBar) {
        Product product = findByCodeBarUseCase.findBy(codeBar);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Product product) {
        createUseCase.create(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{codeBar}")
    public ResponseEntity<Void> update(@PathVariable String codeBar, @RequestBody Product product) {
        editByCodeBarUseCase.editBy(codeBar, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{codeBar}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String codeBar) {
        deleteByCodeBarUseCase.deleteBy(codeBar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
