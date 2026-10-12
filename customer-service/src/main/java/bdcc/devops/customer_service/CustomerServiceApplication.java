package bdcc.devops.customer_service;

import bdcc.devops.customer_service.entities.Customer;
import bdcc.devops.customer_service.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService) {
		return args -> {
			List.of("Mohamed", "Imane", "Yassine").forEach(name ->
					customerService.saveCustomer(Customer.builder()
							.name(name).email(name + "@gmail.com").build()));
		};
	}
}
