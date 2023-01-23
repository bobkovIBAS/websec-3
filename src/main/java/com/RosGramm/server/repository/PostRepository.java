package com.RosGramm.server.repository;


import com.RosGramm.server.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface PostRepository extends MongoRepository<Post, String > {
    List<Post> findAll();
    Post insert(Post post);
    @Query("{ 'idUser' : ?0 }")
    List<Post> findByIdUser (String idUser);
    @Query("{ 'label' : ?0 }")
    Post findByLabel(String label);

}
