package com.shopflow.domain.model;

import java.math.BigDecimal;


public class Product {
    private String barCode;
    private String name;
    private BigDecimal price_sell;
    private BigDecimal price_buy;
    private int  stock;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(BigDecimal price_sell) {
        this.price_sell = price_sell;
    }

    public BigDecimal getPrice_buy() {
        return price_buy;
    }

    public void setPrice_buy(BigDecimal price_buy) {
        this.price_buy = price_buy;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
