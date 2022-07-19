package com.nttdata.customer.service;

import com.nttdata.customer.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();

    Flux<Customer> findAllByCustomerType(String type);

    Mono<Customer> findById(String id);

    Mono<Customer> save(Customer customer);

    Mono<Customer> update(Customer customer);

    Mono<Customer> delete(String id);

    Mono<Customer> findByDocNumber(String docNumber);
}
