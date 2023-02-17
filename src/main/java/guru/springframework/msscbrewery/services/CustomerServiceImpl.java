package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer getCustomerById(UUID custId) {
        return Customer.builder()
                .id(custId)
                .name("James")
                .build();
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return Customer.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID custId, Customer customer) {
        //todo a real BeerDto update
    }

    @Override
    public void deleteById(UUID custId) {
        log.debug("Deleting a customer...");
    }
}
