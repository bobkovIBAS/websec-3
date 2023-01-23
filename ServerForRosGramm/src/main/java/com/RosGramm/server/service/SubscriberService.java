package com.RosGramm.server.service;



import java.io.IOException;

public interface SubscriberService {
   void add(String emailUser, String emailSubscriber) throws IOException;

}
