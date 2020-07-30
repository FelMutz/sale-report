package com.salereport.mapper;

import com.salereport.model.ItemModel;
import com.salereport.model.SaleModel;

import java.util.List;

public class SaleMapper {
    public static SaleModel mapToModel(List<String> stringList) {
        List<ItemModel> items = ItemMapper.mapToListModel(stringList.get(2));

        return SaleModel.builder()
                .id(Integer.parseInt(stringList.get(1)))
                .items(items)
                .salesmanName(stringList.get(3))
                .salePrice(calcSalePrice(items))
                .build();
    }

    private static Double calcSalePrice(List<ItemModel> items) {
        return items.stream()
                .mapToDouble(itemModel -> itemModel.getAmount()*itemModel.getPrice())
                .sum();
    }
}
