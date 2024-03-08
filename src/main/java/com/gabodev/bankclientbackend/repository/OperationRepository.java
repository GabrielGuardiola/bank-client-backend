package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, String> {
    List<Operation> findByOriginAccountId(String originAccountId);
    //find all operations related to a client id. get origin and destination accounts
    List<Operation> findByOriginAccountIdOrDestinationAccountId(String originAccountId, String destinationAccountId);
}