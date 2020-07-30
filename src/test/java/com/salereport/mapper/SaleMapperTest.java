package com.salereport.mapper;

import com.salereport.stub.SaleModelStub;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleMapperTest {
    @Test
    public void should_return_sale() {
        assertEquals(SaleModelStub.getSaleModel(), SaleMapper.mapToModel(SaleModelStub.getListSaleModel()));
    }
}