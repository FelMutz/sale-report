package com.salereport.mapper;

import java.util.Arrays;
import java.util.List;

public class FileMapper {

    public static final String SEPARATOR = "ç";

    public static List<String> mapToListString(String line) {
        return Arrays.asList(line.split(SEPARATOR));
    }
}
