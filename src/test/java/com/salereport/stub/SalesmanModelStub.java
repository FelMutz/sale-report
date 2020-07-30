package com.salereport.stub;

import com.salereport.model.SalesmanModel;

import java.util.*;

public class SalesmanModelStub {
    public static SalesmanModel getSalesmanModel() {
        return SalesmanModel.builder()
                .cpf("1234567891234")
                .name("Pedro")
                .salary(50000d)
                .build();
    }

    public static List<String> getListStringBySalesman() {
        return List.of("001","1234567891234","Pedro","50000");
    }
}
