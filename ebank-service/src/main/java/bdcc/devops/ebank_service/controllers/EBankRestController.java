package bdcc.devops.ebank_service.controllers;

import bdcc.devops.ebank_service.entities.BankAccount;
import bdcc.devops.ebank_service.service.EBankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EBankRestController {
    private final EBankService eBankService;
    public EBankRestController(EBankService s) { this.eBankService = s; }

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() { return eBankService.getAllBankAccounts(); }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) { return eBankService.getBankAccountById(id); }

    @PostMapping("/accounts")
    public BankAccount save(@RequestBody BankAccount account) { return eBankService.save(account); }
}
