package com.salereport.mapper;

import org.junit.Test;

import static com.salereport.stub.ClientModelStub.getClientModel;
import static com.salereport.stub.ClientModelStub.getListStringByClient;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientMapperTest {

    @Test
    public void should_return_client() {
        assertEquals(getClientModel(), ClientMapper.mapToModel(getListStringByClient()));
    }

}