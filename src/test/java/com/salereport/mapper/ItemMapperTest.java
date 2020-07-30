package com.salereport.mapper;

import com.salereport.stub.ItemModelStub;
import org.junit.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class ItemMapperTest {

    @Test
    public void should_ruturn_null_when_item_null() {
        assertNull(ItemMapper.mapToListModel(null));
    }

    @Test
    public void should_ruturn_item() {
        assertArrayEquals(ItemModelStub.getListItemModel(Collections.singletonList(1)).toArray(),
                ItemMapper.mapToListModel(ItemModelStub
                        .getStringByItem(Collections.singletonList("1"))).toArray());
    }
}