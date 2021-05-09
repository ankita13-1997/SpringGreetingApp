package com.bridzelabz.greetingapp.service;

import com.bridzelabz.greetingapp.model.MessageGreet;
import com.bridzelabz.greetingapp.model.User;

public interface IGreetingService {

    MessageGreet addGreeting(User user);
    MessageGreet findUsersById(long id);
}
