package com.salereport.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConfigProperties {
    @Value("${pathToRead}")
    private String pathToRead;
    @Value("${pathToWrite}")
    private String pathToWrite;
}
