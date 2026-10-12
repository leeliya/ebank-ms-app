package bdcc.devops.ebank_service.feign;

import bdcc.devops.customer_service.entities.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
@CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
public interface  CustomerRestClient {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id, Exception e) {
        return new Customer(id, "Not available", "Not available");
    }
}
