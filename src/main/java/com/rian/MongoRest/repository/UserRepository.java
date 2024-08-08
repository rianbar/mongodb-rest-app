package com.rian.MongoRest.repository;

import com.rian.MongoRest.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {
}
