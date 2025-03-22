package dev.emir.dto;

import dev.emir.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convertDto(Customer customer) {

        return new CustomerDto(customer.getId(),customer.getName(),customer.getMail());

    }
}
