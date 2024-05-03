package com.mskim.singlemongodb.repository;

import com.mskim.singlemongodb.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByData(String data);

    Boolean existsByData(String data);

}
