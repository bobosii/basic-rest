package dev.emir.dto;

import dev.emir.entities.Customer;
import org.springframework.stereotype.Component;

// I don't use this class. This class is just example for how to convert two classes manually.
// I'm using modelMapper for convert process in this project
@Component
public class CustomerDtoConverter {

    public CustomerDto convertDto(Customer customer) {

        return new CustomerDto(customer.getId(),customer.getName(),customer.getMail());

    }
}
