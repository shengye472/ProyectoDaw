package com.shopflow.controller;

import com.shopflow.controller.common.PaginatedResponse;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.usecase.common.FindAllUseCase;
import com.shopflow.domain.usecase.product.CreateProductUseCase;
import com.shopflow.domain.usecase.product.DeleteByCodeBarUseCase;
import com.shopflow.domain.usecase.product.EditByCodeBarUseCase;
import com.shopflow.domain.usecase.product.FindByCodeBarUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProductController.URL)
@CrossOrigin(origins = "http://localhost:4200")
public class  ProductController {
    public static final String URL = "/api/products";

    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    @Autowired
    private FindAllUseCase<Product> findAllUseCase;
    @Autowired
    private FindByCodeBarUseCase findByCodeBarUseCase;
    @Autowired
    private CreateProductUseCase createUseCase;
    @Autowired
    private DeleteByCodeBarUseCase deleteByCodeBarUseCase;
    @Autowired
    private EditByCodeBarUseCase editByCodeBarUseCase;

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
        Product product = findByCodeBarUseCase.findByCodeBar(codeBar);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{codeBar}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String codeBar) {
        deleteByCodeBarUseCase.deleteByCodeBar(codeBar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
