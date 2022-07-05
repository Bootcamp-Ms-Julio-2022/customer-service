package com.nttdata.customerservice.controller;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/state")
    public String displayState() {
        return "Service is up";
    }

    // -------------------Retrieve all customers

    @GetMapping
    public Flux<Customer> retrieveAll() {
        log.info("Retrieving all customers");
        return customerService.findAll();
    }

    // -------------------Retrieve all customers by type

    @GetMapping("/type")
    public Flux<Customer> retrieveAllByType(@RequestParam(value = "type", required = false) String type) {
        log.info("Retrieving customers with type: " + type.toUpperCase());
        return type.isEmpty() ?
                customerService.findAll() :
                customerService.findAllByCustomerType(type.toUpperCase());
    }

    // -------------------Retrieve single customer by id

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Customer>> retrieveById(@PathVariable("id") String id) {
        log.info("Retrieving customer with id: " + id);
        Mono<Customer> customer = customerService.findById(id);
        return customer.map(c -> ResponseEntity.ok(c))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // -------------------Create a customer

    @PostMapping
    public Mono<Customer> save(@RequestBody Customer customer) {
        log.info("Registering new customer - name: " + customer.getName() + ", type: " + customer.getCustomerType());
        return customerService.save(customer);
    }

    // -------------------Update a customer

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Customer>> update(@PathVariable("id") String id, @RequestBody Customer customer) {
        log.info("Updating customer with id: " + id);
        return customerService.update(id, customer)
                .map(updatedCustomer -> ResponseEntity.ok(updatedCustomer))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    // -------------------Delete a customer

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id) {
        log.info("Deleting customer with id: " + id);
        return customerService.delete(id)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
