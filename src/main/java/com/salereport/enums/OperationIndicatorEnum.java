package com.salereport.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OperationIndicatorEnum {
    SALESMAN("001"),
    CLIENT("002"),
    SALE("003");

    private String operationIndicator;

    public Boolean validIsOperationIndicator(String value) {
        return this.operationIndicator.equals(value);
    }
}
