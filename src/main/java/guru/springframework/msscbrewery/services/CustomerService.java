package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID custId);

    Customer saveNewCustomer(Customer customer);

    void updateCustomer(UUID custId, Customer customer);

    void deleteById(UUID custId);
}
