package com.salereport.mapper;

import com.salereport.model.ClientModel;

import java.util.List;

public class ClientMapper {
    public static ClientModel mapToModel(List<String> stringList) {
        return ClientModel.builder()
                .cnpj(stringList.get(1))
                .name(stringList.get(2))
                .businessArea(stringList.get(3))
                .build();
    }
}
