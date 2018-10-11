package com.capgemini.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.order.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {

}
