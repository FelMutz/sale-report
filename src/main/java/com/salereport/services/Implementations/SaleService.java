package com.salereport.services.Implementations;

import com.salereport.enums.OperationIndicatorEnum;
import com.salereport.mapper.SaleMapper;
import com.salereport.model.SaleMode;
import com.salereport.repository.SaleRepository;
import com.salereport.services.ServiceFacade;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SaleService implements ServiceFacade {

    private SaleRepository saleRepository = SaleRepository.getSaleRepository();

    @Override
    public void save(List<String> value) {
        saleRepository.getSales()
                .add(SaleMapper.mapToModel(value));
    }

    @Override
    public Boolean isValid(String value) {
        return OperationIndicatorEnum.SALE.validIsOperationIndicator(value);
    }

    public Integer getIdMoreExpencifySale() {
        return saleRepository.getSales()
                .stream()
                .max(Comparator.comparing(SaleMode::getSalePrice))
                .map(SaleMode::getId)
                .orElse(null);
    }
}
