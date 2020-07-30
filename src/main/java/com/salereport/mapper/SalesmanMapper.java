package com.salereport.mapper;

import com.salereport.model.SalesmanModel;

import java.util.List;

public class SalesmanMapper {
    public static SalesmanModel mapToModel(List<String> stringList) {
        return SalesmanModel.builder()
                .cpf(stringList.get(1))
                .name(stringList.get(2))
                .salary(Double.parseDouble(stringList.get(3)))
                .build();
    }
}
