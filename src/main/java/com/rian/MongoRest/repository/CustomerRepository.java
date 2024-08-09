package com.rian.MongoRest.repository;

import com.rian.MongoRest.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerModel, String> {
}
