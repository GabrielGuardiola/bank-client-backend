package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.model.Operation;
import com.gabodev.bankclientbackend.enums.OperationType;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OperationRepository implements IOperationRepository {

    private final List<Operation> operationList = new ArrayList<>();

    public OperationRepository() {
        operationList.add(new Operation("1", 100.0, "1", "2","10-10-1999", OperationType.TRANSFER));
        operationList.add(new Operation("2", 2000, null, "3","10-11-2000", OperationType.WITHDRAWAL));
    }
    @Override
    public List<Operation> getOperationsByAccountId(String accountId) {
        List<Operation> operations = new ArrayList<>();
        for(Operation operation : operationList) {
            if(operation.getOriginAccountId().equals(accountId) || operation.getDestinationAccountId().equals(accountId)) {
                operations.add(operation);
            }
        }
        return operations;
    }

    @Override
    public void save(Operation operation) {
        operationList.add(operation);
        System.out.println("Operation list: " + operationList);
    }
}
