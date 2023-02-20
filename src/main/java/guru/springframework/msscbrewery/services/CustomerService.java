package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID custId);

    CustomerDto saveNewCustomer(CustomerDto customer);

    void updateCustomer(UUID custId, CustomerDto customer);

    void deleteById(UUID custId);
}
