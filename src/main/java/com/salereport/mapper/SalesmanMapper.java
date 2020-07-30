package com.salereport.mapper;

import com.salereport.model.SalesmanMode;

import java.util.List;

public class SalesmanMapper {
    public static SalesmanMode mapToModel(List<String> stringList) {
        return SalesmanMode.builder()
                .cpf(stringList.get(1))
                .name(stringList.get(2))
                .salary(Double.parseDouble(stringList.get(3)))
                .build();
    }
}
