package com.salereport.services;

import java.util.List;

public interface ServiceFacade {
    void save(List<String> value);
    Boolean isValid(String value);
}
