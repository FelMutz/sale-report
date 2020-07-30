package com.salereport.stub;

import com.salereport.model.SaleModel;

import java.util.*;

public class SaleModelStub {

    public static SaleModel getSaleModel() {
        return SaleModel.builder()
                .id(10)
                .items(ItemModelStub.getListItemModel(List.of(1,2,3)))
                .salePrice(66d)
                .salesmanName("Pedro")
                .build();
    }

    public static List<String> getListSaleModel(){
        return List.of("003","10","["+ItemModelStub.getStringByItem(List.of("1","2","3"))+"]","Pedro");
    }
}
