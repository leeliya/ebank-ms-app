package bdcc.devops.ebank_service.service;

import bdcc.devops.ebank_service.entities.BankAccount;
import bdcc.devops.ebank_service.feign.CustomerRestClient;
import bdcc.devops.ebank_service.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service

public class EBankService {
    private final BankAccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;


    public EBankService(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    public List<BankAccount> getAllBankAccounts() { return accountRepository.findAll(); }

    public BankAccount getBankAccountById(String id) {
        BankAccount account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setCustomer(customerRestClient.getCustomerById(account.getCustomerId()));
        return account;
    }

    public BankAccount save(BankAccount account) {
        try {
            customerRestClient.getCustomerById(account.getCustomerId());
            account.setId(UUID.randomUUID().toString());
            account.setCreatedAt(new Date());
            return accountRepository.save(account);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
