package com.gabodev.bankclientbackend.repository;

import com.gabodev.bankclientbackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByIBAN(String IBAN);

    List<Account> findByClientOwner(Integer clientId);

}