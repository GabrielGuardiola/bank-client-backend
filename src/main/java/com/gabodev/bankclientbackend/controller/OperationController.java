package com.gabodev.bankclientbackend.controller;

import com.gabodev.bankclientbackend.dto.TransferAmountToAnotherAccountRequest;
import com.gabodev.bankclientbackend.dto.depositOrWithdrawAmountToClientAccountRequest;
import com.gabodev.bankclientbackend.entity.Operation;
import com.gabodev.bankclientbackend.service.IAccountService;
import com.gabodev.bankclientbackend.service.IOperationService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/operations")
public class OperationController {
    private final IOperationService operationService;

    public OperationController(IOperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/init")
    public Map<String, Boolean> init() {
        operationService.init();
        return Map.of("success", true);
    }

    @PostMapping("/deposit")
    public Map<String, Boolean> depositAmountToClientAccount(@RequestBody depositOrWithdrawAmountToClientAccountRequest request) {
        String IBAN = request.getIBAN();
        double amount = request.getAmount();
        Integer clientId = request.getClientId();
        operationService.depositAmountToClientAccount(IBAN, amount, clientId);
        return Map.of("success", true);
    }
    @PostMapping("/withdraw")
    public Map<String, Boolean> withdrawAmountToClientAccount(@RequestBody depositOrWithdrawAmountToClientAccountRequest request) {
        String IBAN = request.getIBAN();
        double amount = request.getAmount();
        Integer clientId = request.getClientId();
        operationService.withdrawAmountToClientAccount(IBAN, amount, clientId);
        return Map.of("success", true);
    }
    @PostMapping("/transfer")
    public Map<String, Boolean> transferAmountToAnotherAccount(@RequestBody TransferAmountToAnotherAccountRequest request) {
        String originIBAN = request.getSourceIBAN();
        String targetIBAN = request.getTargetIBAN();
        double amount = request.getAmount();
        operationService.transferAmountToAnotherAccount(originIBAN, targetIBAN, amount);
        return Map.of("success", true);
    }
    @GetMapping("/{IBAN}")
    public Map<String, List<Operation>> getOperationsByAccountId(@PathVariable String IBAN) {
        return Map.of("operations", operationService.getOperationsByAccountId(IBAN));
    }
}
