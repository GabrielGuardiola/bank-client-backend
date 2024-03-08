package com.gabodev.bankclientbackend.controller;

import com.gabodev.bankclientbackend.service.IAccountService;
import org.springframework.web.bind.annotation.*;

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
    public String getAccountsByClientId(@PathVariable Integer clientId) {
        System.out.println("Client ID: " + clientId);
        return accountService.getAccountsByClientId(clientId).toString();
    }

    @GetMapping("/accounts/all")
    public String getAccountList() {
        return accountService.getAccountList().toString();
    }

}
