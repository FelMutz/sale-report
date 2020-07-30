package com.salereport.repository;

import com.salereport.model.SaleMode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class SaleRepository {
    @Getter
    private Set<SaleMode> sales;
    @Getter
    private static final SaleRepository saleRepository = new SaleRepository();

    public SaleRepository() {
        this.sales = new HashSet<>();
    }
}
