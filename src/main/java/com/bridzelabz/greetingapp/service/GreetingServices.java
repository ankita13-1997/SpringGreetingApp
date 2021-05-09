package com.bridzelabz.greetingapp.service;

import com.bridzelabz.greetingapp.model.MessageGreet;
import com.bridzelabz.greetingapp.model.User;
import com.bridzelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServices implements IGreetingService{
    private static final String template ="Hello %s!";
    private final AtomicLong counter =new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public MessageGreet addGreeting(User user) {
       String message=String.format(template,(user.toString().isEmpty()) ? "Hello World" : user.toString());
       return greetingRepository.save(new MessageGreet(counter.incrementAndGet(),message));
    }

    @Override
    public MessageGreet findUsersById(long id) {
        return greetingRepository.findById(id).get();
    }
}
