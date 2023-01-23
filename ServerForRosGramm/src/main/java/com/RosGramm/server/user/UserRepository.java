package com.RosGramm.server.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Integer> {
    List<User> findAllByFirstname(String firstname);
    Optional<User> findByEmail(String email);
    Optional<User> findById(String id);
}
