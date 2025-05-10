package com.shopflow.domain.model;

import java.math.BigDecimal;

public class Detail {
    private int quantity;
    private BigDecimal subtotal;
    private Product products;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public BigDecimal calculateSubtotal(int quantity, BigDecimal price) {
        return price.multiply(new BigDecimal(quantity));
    }
}
