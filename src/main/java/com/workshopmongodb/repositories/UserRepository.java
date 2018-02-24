package com.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.workshopmongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}