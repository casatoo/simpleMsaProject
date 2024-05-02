package com.mskim.singlemongodb.repository;

import com.mskim.singlemongodb.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
