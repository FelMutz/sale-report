package com.salereport.mapper;

import com.salereport.model.ItemModel;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemMapper {
    private static final String SEPARATOR_ITEMS = ",";
    private static final String SEPARATOR = "-";

    public static List<ItemModel> mapToListModel(String itemString) {
        return Optional.ofNullable(itemString)
                .map(s -> s.replace("[", ""))
                .map(s -> s.replace("]", ""))
                .map(s -> s.split(SEPARATOR_ITEMS))
                .map(Arrays::stream)
                .map(stringStream -> stringStream
                        .map(s -> mapToModel(Arrays.asList(s.split(SEPARATOR))))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    private static ItemModel mapToModel(List<String> stringList) {
        return ItemModel.builder()
                .id(Integer.parseInt(stringList.get(0)))
                .amount(Integer.parseInt(stringList.get(1)))
                .price(Double.parseDouble(stringList.get(2)))
                .build();
    }
}
