package com.salereport.mapper;

import com.salereport.stub.SalesmanModelStub;
import org.junit.Test;

import static com.salereport.stub.SalesmanModelStub.getListStringBySalesman;
import static org.junit.jupiter.api.Assertions.*;

public class SalesmanMapperTest {
    @Test
    public void should_return_salesman() {
        assertEquals(SalesmanModelStub.getSalesmanModel(),
                SalesmanMapper.mapToModel(getListStringBySalesman()));
    }
}