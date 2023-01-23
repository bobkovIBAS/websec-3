package com.RosGramm.server.service;


import com.RosGramm.server.model.Like;
import com.RosGramm.server.model.Post;
import com.RosGramm.server.repository.LikeRepository;
import com.RosGramm.server.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LikeServiceImpl implements LikeService{

    private final PostService postService;
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;


    @Override
    public void add(String label) {
        Post post = postService.findPostByLabel(label);
        Integer counter = post.getCounterLike();
        counter++;
        postRepository.save(new Post(post.getId(),post.getEncodedPhoto(),post.getLabel(),post.getIdUser(),counter));
    }
}
