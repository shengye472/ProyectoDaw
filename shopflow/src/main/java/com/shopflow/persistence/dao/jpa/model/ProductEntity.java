package com.shopflow.persistence.dao.jpa.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "bar_code")
    private String barCode;
    private String name;
    private BigDecimal price_sell;
    private BigDecimal price_buy;
    private int  stock;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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