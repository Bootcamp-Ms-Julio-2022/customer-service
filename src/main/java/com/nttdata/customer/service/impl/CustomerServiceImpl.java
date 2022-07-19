package com.nttdata.customer.service.impl;

import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.repository.CustomerRepository;
import com.nttdata.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Flux<Customer> findAllByCustomerType(String type) {
        return customerRepository.findAllByCustomerType(type);
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        customer.setCreatedAt(new Date());
        customer.setState("active");
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return customerRepository.findById(customer.getId())
                .flatMap(c -> {
                    c.setCustomerType(customer.getCustomerType());
                    c.setName(customer.getName());
                    c.setDocType(customer.getDocType());
                    c.setDocNumber(customer.getDocNumber());
                    c.setAddress(customer.getAddress());
                    c.setPhoneNumber(customer.getPhoneNumber());
                    c.setState(customer.getState());
                    c.setEmail(customer.getEmail());
                    c.setImeiMobilePhoneNumber(customer.getImeiMobilePhoneNumber());
                    c.setLastModifiedAt(new Date());
                    return customerRepository.save(c);
                });
    }

    @Override
    public Mono<Customer> delete(String id) {
        return customerRepository.findById(id)
                .flatMap(c -> customerRepository.delete(c)
                        .then(Mono.just(c)));
    }

    @Override
    public Mono<Customer> findByDocNumber(String docNumber) {
        return customerRepository.findCustomerByDocNumber(docNumber);
    }
}
