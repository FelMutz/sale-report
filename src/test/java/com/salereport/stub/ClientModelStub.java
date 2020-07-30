package com.salereport.stub;

import com.salereport.model.ClientModel;

import java.util.*;

public class ClientModelStub {
    public static ClientModel getClientModel() {
        return ClientModel.builder()
                .cnpj("2345675434544345")
                .name("Jose da Silva")
                .businessArea("Rural")
                .build();
    }

    public static List<String> getListStringByClient(){
        return List.of("002","2345675434544345","Jose da Silva","Rural");
    }
}
