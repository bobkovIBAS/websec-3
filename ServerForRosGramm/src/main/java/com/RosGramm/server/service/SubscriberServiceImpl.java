package com.RosGramm.server.service;

import com.RosGramm.server.model.Subscriber;
import com.RosGramm.server.repository.SubscriberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberRepository subscriberRepository;




    @Override
    public void add(String emailUser, String emailSubscriber) throws IOException {
        Subscriber subscriber = new Subscriber(emailUser,emailSubscriber);
        subscriberRepository.insert(subscriber);
    }
}
