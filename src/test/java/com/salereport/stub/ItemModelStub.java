package com.salereport.stub;

import com.salereport.model.ItemModel;

import java.util.*;
import java.util.stream.Collectors;

public class ItemModelStub {

    public static List<ItemModel> getListItemModel (List<Integer> itemCode) {
        return itemCode.stream()
                .map(ItemModelStub::getItemModel)
                .collect(Collectors.toList());
    }

    private static ItemModel getItemModel(Integer itemCode) {
        return ItemModel.builder()
                .id(itemCode)
                .price(2.20d)
                .amount(10)
                .build();
    }

    public static String getStringByItem (List<String> idItems) {
        return idItems.stream()
                .map(s -> s+"-10-2.20")
                .collect(Collectors.joining(","));
    }
}
