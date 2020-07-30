package com.salereport.repository;

import com.salereport.model.SalesmanMode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class SalesmanRepository {

    @Getter
    private Set<SalesmanMode> salesmans;
    @Getter
    private static final SalesmanRepository salesmanRepository = new SalesmanRepository();

    public SalesmanRepository() {
        this.salesmans = new HashSet<>();
    }
}
