package bdcc.devops.ebank_service;

import bdcc.devops.ebank_service.entities.BankAccount;
import bdcc.devops.ebank_service.service.EBankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(EBankService eBankService) {
		return args -> {
			for (long i = 1; i <= 3; i++) {
				for (int j = 0; j < 5; j++) {
					eBankService.save(BankAccount.builder()
							.type(Math.random() > 0.5 ? "current-account" : "saving-account")
							.balance(1000 + Math.random() * 60000)
							.customerId(i)
							.build());
				}
			}
		};
	}
}
