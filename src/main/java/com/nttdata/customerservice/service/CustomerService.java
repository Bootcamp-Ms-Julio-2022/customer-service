package com.nttdata.customerservice.service;

import com.nttdata.customerservice.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();

    Flux<Customer> findAllByCustomerType(String type);

    Mono<Customer> findById(String id);

    Mono<Customer> save(Customer customer);

    Mono<Customer> update(String id, Customer customer);

    Mono<Customer> delete(String id);
}
