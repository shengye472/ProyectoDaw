package com.shopflow.domain.usecase.impl.sale;

import com.shopflow.common.annotation.DomainTransactional;
import com.shopflow.common.annotation.DomainUseCase;
import com.shopflow.common.exception.ResourceNotFoundException;
import com.shopflow.domain.model.Detail;
import com.shopflow.domain.model.Product;
import com.shopflow.domain.model.Sale;
import com.shopflow.domain.service.ProductService;
import com.shopflow.domain.service.SaleService;
import com.shopflow.domain.usecase.sale.CreateSaleUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DomainUseCase
@DomainTransactional
public class CreateSaleUseCaseImpl implements CreateSaleUseCase {

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @Override
    public void create(Sale data) {
        Sale venta = new Sale();

        venta.setDate(LocalDateTime.now());

        venta.setTotal(getTotal(data));

        List<Detail> detailList = new ArrayList<>();

        for (Detail productDetail : data.getDetails()){
            Detail detail = new Detail();
            Product producto =findProduct(productDetail.getProducts().getBarCode());
            detail.setProducts(producto);
            detail.setQuantity(productDetail.getQuantity());
            BigDecimal subtotal = detail.calculateSubtotal(productDetail.getQuantity(), producto.getPrice_sell());
            detail.setSubtotal(subtotal);

            detailList.add(detail);
        }

        venta.setDetails(detailList);

        saleService.save(venta);
    }

    private BigDecimal getTotal(Sale data) {
        List<BigDecimal> subtotalList = new ArrayList<>();
        for (Detail productDetail : data.getDetails()){
            Product producto =findProduct(productDetail.getProducts().getBarCode());
            BigDecimal subtotal = productDetail.calculateSubtotal(productDetail.getQuantity(), producto.getPrice_sell());
            subtotalList.add(subtotal);
        }
        return data.calculateTotal(subtotalList);
    }

    private Product findProduct(String codeBar) {
        return productService.findByBarCode(codeBar)
                .orElseThrow(() -> new ResourceNotFoundException("Product with codeBar " + codeBar + " not found"));
    }

}
