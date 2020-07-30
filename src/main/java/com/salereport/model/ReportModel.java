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
public class ReportModel {
    private String file;
    private Integer amountClientAtFile;
    private Integer amountSalesmanAtFile;
    private Integer amountClientOnMemory;
    private Integer amountSalesmanOnMemory;
    private Integer SaleMoreExpensifyOnMemory;
    private List<SalesmanMode> worstSalesmanOnMemory;
}
