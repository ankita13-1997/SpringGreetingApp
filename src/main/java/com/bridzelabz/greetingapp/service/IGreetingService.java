package com.bridzelabz.greetingapp.service;

import com.bridzelabz.greetingapp.model.MessageGreet;
import com.bridzelabz.greetingapp.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {

    MessageGreet addGreeting(User user);
    MessageGreet findUsersById(long id);
    void deleteById(long id);
    List<MessageGreet> getAllUsers();
    MessageGreet updateGreetingMessage(long id, User user);

}
