package com.RosGramm.server.repository;

import com.RosGramm.server.model.Like;
import com.RosGramm.server.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like, String > {
    Like insert(Like like);

}
