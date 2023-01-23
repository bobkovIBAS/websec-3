package com.RosGramm.server.controllers;


import com.RosGramm.server.service.LikeService;
import com.RosGramm.server.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@CrossOrigin("http://localhost:4200")
public class LikeController {

    private final LikeService likeService;
    private final PostService postService;

    public LikeController(LikeService likeService, PostService postService) {
        this.likeService = likeService;
        this.postService = postService;
    }


    @PostMapping("/addLike")
    @ResponseBody
    private ResponseEntity<?> uploadProfilePost(@RequestPart(value = "label") String label) {
        likeService.add(label);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
