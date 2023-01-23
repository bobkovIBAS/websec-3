package com.RosGramm.server.controllers;


import com.RosGramm.server.DAO.SubscriberDAO;
import com.RosGramm.server.model.Subscriber;
import com.RosGramm.server.repository.SubscriberRepository;
import com.RosGramm.server.user.User;
import com.RosGramm.server.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subscriber")
@CrossOrigin("http://localhost:4200")
public class SubscriberController {

    private final UserRepository repository;
    private final SubscriberRepository subscriberRepository;

    public SubscriberController(UserRepository repository, SubscriberRepository subscriberRepository) {
        this.repository = repository;
        this.subscriberRepository = subscriberRepository;
    }

    @PostMapping("/add-subscriber")
    @ResponseBody
    private ResponseEntity<List<String>> addSubscriber(@RequestPart(value = "email") String email) {


        return new ResponseEntity<>( HttpStatus.OK);
    }



    @PostMapping("/find-users")
    @ResponseBody
    private ResponseEntity<List<SubscriberDAO>> findUsers(@RequestPart(value = "firstname") String firstname) {
        var user = repository.findAllByFirstname(firstname);
        List<SubscriberDAO> daoList = new ArrayList<>();
        for (User finded:user) {
            daoList.add(new SubscriberDAO(finded.getFirstname(),finded.getLastname(),finded.getEmail()));
        }

        return new ResponseEntity<>(daoList,HttpStatus.OK);
    }
}
