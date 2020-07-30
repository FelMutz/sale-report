package com.salereport.mapper;

import com.salereport.stub.ClientModelStub;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileMapperTest {

    @Test
    public void should_return_list_string_by_client() {
        assertEquals(ClientModelStub.getListStringByClient(),
                FileMapper.mapToListString("002ç2345675434544345çJose da SilvaçRural"));
    }
}