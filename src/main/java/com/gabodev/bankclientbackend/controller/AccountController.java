package com.gabodev.bankclientbackend.controller;

import com.gabodev.bankclientbackend.model.Account;
import com.gabodev.bankclientbackend.service.IAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/init")
    public String init() {
        accountService.init();
        return "Init OK";
    }
    @GetMapping("/accounts/{clientId}")
    public Map<String, List<Account>> getAccountsByClientId(@PathVariable Integer clientId) {
        List<Account> accounts = accountService.getAccountsByClientId(clientId);
        Map<String, List<Account>> response = new HashMap<>();
        response.put("accounts",accounts);
        return response;
    }

    @GetMapping("/accounts/all")
    public Map<String, List<Account>> getAccountList() {
        List<Account> accounts = accountService.getAccountList();
        Map<String, List<Account>> response = new HashMap<>();
        response.put("accounts",accounts);
        return response;
    }

}
