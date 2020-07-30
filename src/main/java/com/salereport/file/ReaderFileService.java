package com.salereport.file;

import com.salereport.mapper.FileMapper;
import com.salereport.services.ServiceFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ReaderFileService {
    private List<ServiceFacade> serviceFacadeList;

    public void loadFile(List<File> files) {
        readAllLine(files)
                .forEach(this::saveData);
    }

    public List<String> readAllLine(List<File> files) {
        return files.stream()
                .map(file -> {
                    try {
                        return Files.readAllLines(file.toPath());
                    } catch (IOException e) {
                        log.error("Erro ao acessar arquivo. Dados da exception: " + e.getMessage());
                        return null;
                    }
                }).filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private void saveData(String line) {
        Optional.ofNullable(line)
                .map(FileMapper::mapToListString)
                .ifPresent(stringList -> serviceFacadeList.stream()
                        .filter(serviceFacade -> serviceFacade.isValid(stringList.get(0)))
                        .findFirst()
                        .ifPresent(serviceFacade -> serviceFacade.save(stringList)));

    }
}
