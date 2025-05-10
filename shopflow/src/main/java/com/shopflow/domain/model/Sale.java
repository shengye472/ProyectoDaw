package com.shopflow.domain.model;

import com.shopflow.persistence.dao.jpa.model.DetailEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private Integer id;
    private LocalDateTime date;
    private BigDecimal total;
    private List<Detail> details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public BigDecimal calculateTotal(List<BigDecimal> subtotalList) {
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal subtotal : subtotalList) {
            total = total.add(subtotal);
        }
        return total;
    }
}
