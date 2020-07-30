package com.salereport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleMode {
    private Integer id;
    private String salesmanName;
    private List<ItemModel> items;
    private Double salePrice;
}
