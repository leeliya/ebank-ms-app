package bdcc.devops.ebank_service.service;

import bdcc.devops.ebank_service.entities.BankAccount;
import bdcc.devops.ebank_service.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service

public class EBankService {
    private final BankAccountRepository accountRepository;

    public EBankService(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<BankAccount> getAllBankAccounts() { return accountRepository.findAll(); }

    public BankAccount getBankAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public BankAccount save(BankAccount account) {
        account.setId(UUID.randomUUID().toString());
        account.setCreatedAt(new Date());
        return accountRepository.save(account);
    }
}
