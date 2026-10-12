package bdcc.devops.ebank_service.entities;

import bdcc.devops.customer_service.entities.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String type;
    private Long customerId;
    @Transient
    private Customer customer;
}

