package com.salereport.file;

import com.salereport.enums.OperationIndicatorEnum;
import com.salereport.mapper.FileMapper;
import com.salereport.model.ReportModel;
import com.salereport.services.Implementations.ClientService;
import com.salereport.services.Implementations.SaleService;
import com.salereport.services.Implementations.SalesmanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.salereport.enums.OperationIndicatorEnum.CLIENT;
import static com.salereport.enums.OperationIndicatorEnum.SALESMAN;

@Service
@AllArgsConstructor
@Slf4j
public class WriteFileService {
    private ClientService clientService;
    private SaleService saleService;
    private SalesmanService salesmanService;
    private ReaderFileService readerFileService;

    public void makeReport(List<File> fileList, String fileName) {
           List<String> lineFile = readerFileService.readAllLine(fileList);
        Optional.ofNullable(lineFile)
                .map(stringList -> makeReportModel(stringList,fileName))
                .ifPresent(this::writeReportOnFile);
    }

    private ReportModel makeReportModel(List<String> stringList, String fileName) {
        List<List<String>> collectList = stringList.stream().map(FileMapper::mapToListString).collect(Collectors.toList());
        return ReportModel.builder()
                .file(fileName)
                .amountClientAtFile(calcHowMuchAtFile(collectList, CLIENT))
                .amountSalesmanAtFile(calcHowMuchAtFile(collectList, SALESMAN))
                .amountClientOnMemory(clientService.calHowMuchIsOnMemory())
                .amountSalesmanOnMemory(salesmanService.calHowMuchIsOnMemory())
                .SaleMoreExpensifyOnMemory(saleService.getIdMoreExpencifySale())
                .worstSalesmanOnMemory(salesmanService.getTheWorstSalesmanOnMemory())
                .build();
    }

    private void writeReportOnFile(ReportModel reportModel) {
        Path logDir = Paths.get("/home/felipe/data/on/SaleReport.dat");
        try (BufferedWriter writer = Files.newBufferedWriter(logDir)) {
            writer.write(reportModel.toString());
            log.info("Relatorio realizado.");
        } catch (IOException e) {
            log.info("Erro ao gerar relatorio. Exception: " + e.getMessage());
        }
    }

    private Integer calcHowMuchAtFile(List<List<String>> stringList, OperationIndicatorEnum operationIndicatorEnum) {
        return Math.toIntExact(stringList.stream()
                .filter(s -> operationIndicatorEnum.validIsOperationIndicator(s.get(0)))
                .distinct()
                .count());
    }
}
