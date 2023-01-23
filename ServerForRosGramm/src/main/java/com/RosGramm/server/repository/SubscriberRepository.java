package com.RosGramm.server.repository;


import com.RosGramm.server.model.Subscriber;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SubscriberRepository extends MongoRepository<Subscriber, String >  {
    Subscriber insert(Subscriber subscriber);
    @Query("{ 'idUser' : ?0 }")
    List<Subscriber> findByIdUser (String idUser);

}
