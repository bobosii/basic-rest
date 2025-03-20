package dev.emir.business.abstracts;

import dev.emir.entities.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getById(int id);
    Customer save(Customer customer);
    Customer update(Customer customer);
    void delete(int id);
    List<Customer> findAll();
}
