package com.RosGramm.server.repository;

import com.RosGramm.server.model.Avatar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface AvatarRepository extends MongoRepository<Avatar, String > {
    Avatar insert(Avatar avatar);
    @Query("{ 'idUser' : ?0 }")
    Optional<Avatar> findByIdUser (String idUser);
    Avatar deleteAllByIdUser(String idUser);

}
