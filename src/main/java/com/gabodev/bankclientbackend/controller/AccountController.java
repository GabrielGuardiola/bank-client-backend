package com.gabodev.bankclientbackend.controller;

import com.gabodev.bankclientbackend.dto.RegisterNewClientAccountRequest;
import com.gabodev.bankclientbackend.entity.Account;
import com.gabodev.bankclientbackend.service.IAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/init")
    public Map<String, Boolean> init() {
        accountService.init();
        return Map.of("success", true);
    }
    @GetMapping("/{clientId}")
    public Map<String, List<Account>> getAccountsByClientId(@PathVariable Integer clientId) {
        List<Account> accounts = accountService.getAccountsByClientId(clientId);
        Map<String, List<Account>> response = new HashMap<>();
        response.put("accounts",accounts);
        return response;
    }

    @GetMapping("/all")
    public Map<String, List<Account>> getAccountList() {
        List<Account> accounts = accountService.getAccountList();
        Map<String, List<Account>> response = new HashMap<>();
        response.put("accounts",accounts);
        return response;
    }

    @PostMapping("/create")
    public Map<String, Boolean> registerNewClientAccount(@RequestBody RegisterNewClientAccountRequest request) {
        accountService.registerNewClientAccount(request.getClientId());
        return Map.of("success", true);
    }
}
