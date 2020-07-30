package com.salereport.services.Implementations;

import com.salereport.enums.OperationIndicatorEnum;
import com.salereport.mapper.ClientMapper;
import com.salereport.repository.ClientRepository;
import com.salereport.services.ServiceFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements ServiceFacade {

    private ClientRepository clientRepository = ClientRepository.getClientRepository();

    @Override
    public void save(List<String> value) {
        clientRepository.getClients()
                .add(ClientMapper.mapToModel(value));
    }

    @Override
    public Boolean isValid(String value) {
        return OperationIndicatorEnum.CLIENT.validIsOperationIndicator(value);
    }

    public Integer calHowMuchIsOnMemory() {
        return clientRepository
                .getClients()
                .size();
    }
}
