package com.salereport.services.Implementations;

import com.salereport.enums.OperationIndicatorEnum;
import com.salereport.mapper.SalesmanMapper;
import com.salereport.model.SaleModel;
import com.salereport.model.SalesmanModel;
import com.salereport.repository.SaleRepository;
import com.salereport.repository.SalesmanRepository;
import com.salereport.services.ServiceFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SalesmanService implements ServiceFacade {

    private SalesmanRepository salesmanRepository = SalesmanRepository.getSalesmanRepository();
    private SaleRepository saleRepository = SaleRepository.getSaleRepository();

    @Override
    public void save(List<String> value) {
        salesmanRepository.getSalesmans()
                .add(SalesmanMapper.mapToModel(value));
    }

    @Override
    public Boolean isValid(String value) {
        return OperationIndicatorEnum.SALESMAN.validIsOperationIndicator(value);
    }

    public Integer calHowMuchIsOnMemory() {
        return salesmanRepository
                .getSalesmans()
                .size();
    }

    public List<SalesmanModel> getTheWorstSalesmanOnMemory() {
        Map<String,Double> valueSaleBySalesman = saleRepository.getSales()
                .stream()
                .collect(Collectors.groupingBy(SaleModel::getSalesmanName,
                        Collectors.summingDouble(SaleModel::getSalePrice)));

        Double lowestTotalSale = valueSaleBySalesman.values().stream().sorted().findFirst().orElse(0d);

        List<String> worstSalesman = valueSaleBySalesman.entrySet()
                .stream()
                .filter(stringDoubleEntry -> Objects.equals(stringDoubleEntry.getValue(), lowestTotalSale))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return salesmanRepository.getSalesmans()
                .stream()
                .filter(salesmanMode -> worstSalesman.contains(salesmanMode.getName()))
                .collect(Collectors.toList());
    }
}
