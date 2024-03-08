package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.model.Operation;

import java.util.List;

public interface IOperationRepository {
   List<Operation> getOperationsByAccountId(String accountId);
   void save(Operation operation);
}
