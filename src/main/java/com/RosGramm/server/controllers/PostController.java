package com.RosGramm.server.controllers;


import com.RosGramm.server.DAO.PostDAO;
import com.RosGramm.server.DAO.PostFollowersDAO;
import com.RosGramm.server.model.Post;
import com.RosGramm.server.model.Subscriber;
import com.RosGramm.server.repository.SubscriberRepository;
import com.RosGramm.server.service.PostService;
import com.RosGramm.server.user.User;
import com.RosGramm.server.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin("http://localhost:4200")
public class PostController {

    private final SubscriberRepository subscriberRepository;
    private final PostService postService;
    private final UserRepository repository;

    public PostController(SubscriberRepository subscriberRepository, PostService postService, UserRepository repository) {
        this.subscriberRepository = subscriberRepository;
        this.postService = postService;
        this.repository = repository;
    }


    @PostMapping(value = "/new-post")
    @ResponseBody
    public ResponseEntity<?> addNewPost(@RequestPart(value = "photo") MultipartFile photo,
                                          @RequestPart(value = "label") String label,
                                          @RequestPart(value = "email") String email) throws IOException {
        var user = repository.findByEmail(email)
                .orElseThrow();
        postService.add(photo, label, user.getId(),0);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/upload-profilePost")
    @ResponseBody
    private ResponseEntity<List<PostDAO>> uploadProfilePost( @RequestPart(value = "email") String email) {
        List<PostDAO> postDAOList =  postService.findPostForDao(email);
        return new ResponseEntity<>(postDAOList, HttpStatus.OK);
    }

    @PostMapping("/upload-subscriberPost")
    @ResponseBody
    private ResponseEntity<List<PostFollowersDAO>> uploadSubscriberPost(@RequestPart(value = "email") String email) {
        var user = repository.findByEmail(email)
                .orElseThrow();
        List<Subscriber> subscriberList = subscriberRepository.findByIdUser(user.getId());
        List<PostFollowersDAO> postDAOList = new ArrayList<>();
        for (Subscriber subscriber: subscriberList) {
            List<Post> postList = postService.findPost(subscriber.getSubscriberId());
            for(Post post: postList){
                User sub = repository.findById(post.getIdUser()).get();

                postDAOList.add(new PostFollowersDAO(post.getEncodedPhoto(),
                        post.getLabel(),
                        sub.getFirstname(),
                        sub.getLastname(),
                        sub.getEmail()));
            }
        }
        return new ResponseEntity<>(postDAOList, HttpStatus.OK);
    }
}
