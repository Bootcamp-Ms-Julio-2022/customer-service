package com.nttdata.customer.repository;

import com.nttdata.customer.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    Flux<Customer> findAllByCustomerType(String customerType);

    Mono<Customer> findCustomerByDocNumber(String docNumber);
}
