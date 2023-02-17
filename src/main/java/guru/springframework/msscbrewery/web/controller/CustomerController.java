package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"{custId}"})
    public ResponseEntity<Customer> getCustomer(@PathVariable("custId")UUID custId){
        return new ResponseEntity<>(customerService.getCustomerById(custId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveNewCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        //Todo get hostname url
        headers.add("Location", "/api/v1/customer/"+savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PutMapping({"{custId}"})
    public ResponseEntity handleUpdate(@PathVariable("custId") UUID custId, @RequestBody Customer customer){
        customerService.updateCustomer(custId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"{custId}"})
    public void deleteBeer(@PathVariable("custId") UUID custId){
        customerService.deleteById(custId);
    }
}
