package com.bridzelabz.greetingapp.service;

import com.bridzelabz.greetingapp.model.MessageGreet;
import com.bridzelabz.greetingapp.model.User;
import com.bridzelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public void deleteById(long id) {
        greetingRepository.deleteById(id);
    }

    @Override
    public List<MessageGreet> getAllUsers() {
        List<MessageGreet> greetList = new ArrayList<MessageGreet>();
        greetingRepository.findAll().forEach(greet ->greetList.add(greet));
        return greetList;
    }

    @Override
    public MessageGreet updateGreetingMessage(long id, User user) {
        MessageGreet messageGreet =greetingRepository.findById(id).orElse(null);
        if (messageGreet !=null){
            String message = String.format(template,(user.toString().isEmpty()) ? "Hello World" : user.toString());
            return greetingRepository.save(new MessageGreet(id,message));
        }
        return null;
    }


}
