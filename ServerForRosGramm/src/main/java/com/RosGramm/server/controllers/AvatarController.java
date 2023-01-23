package com.RosGramm.server.controllers;

import com.RosGramm.server.auth.AuthenticationRequest;
import com.RosGramm.server.model.Avatar;
import com.RosGramm.server.repository.AvatarRepository;
import com.RosGramm.server.service.AvatarService;
import com.RosGramm.server.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/avatar")
@CrossOrigin("http://localhost:4200")
public class AvatarController {

    private final AvatarService avatarService;
    private final UserRepository repository;

    public AvatarController(AvatarService avatarService, UserRepository repository) {
        this.avatarService = avatarService;
        this.repository = repository;
    }

    @PostMapping(value = "/new-avatar")
    @ResponseBody
    public ResponseEntity<?> addNewAvatar(@RequestPart(value = "photo") MultipartFile photo,
                                          @RequestPart(value = "email") String email) throws IOException {
        var user = repository.findByEmail(email)
                .orElseThrow();
        avatarService.checkUserAvatar(user.getId());
        avatarService.add(photo,user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/upload-avatar")
    @ResponseBody
    public ResponseEntity<?> uploadAvatar(@RequestPart(value = "email") String email) {
        //avatarService.findPhoto(email);
        return new ResponseEntity<>(avatarService.findPhoto(email),HttpStatus.OK);
    }

}
