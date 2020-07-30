package com.salereport.observer;

import com.salereport.file.ReaderFileService;
import com.salereport.file.WriteFileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

@Component
@AllArgsConstructor
@Slf4j
public class FileObserver {

    private ReaderFileService readerFileService;
    private WriteFileService writeFileService;

    public void startObserver() {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path logDir = Paths.get("/home/felipe/data/in");
            logDir.register(watcher, ENTRY_CREATE);

            WatchKey key;
            while (!ObjectUtils.isEmpty(key = watcher.take())) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    String file = event.context().toString();
                    log.info("Novo arquivo criado: ." + file);
                    List<File> fileList = Collections.singletonList(new File(logDir + "/" + file));

                    readerFileService
                            .loadFile(fileList);

                    log.info("Dados contidos no arquivo " + file + " foram adicionados com sucesso.");

                    log.info("Analisando dados para o relatorio.");
                    writeFileService.makeReport(fileList, file);
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            log.error("Erro no observable da pasta data/in. Exception: " + e.getMessage());
        }
    }
}
