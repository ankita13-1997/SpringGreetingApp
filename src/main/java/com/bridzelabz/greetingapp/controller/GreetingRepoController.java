package com.bridzelabz.greetingapp.controller;

import com.bridzelabz.greetingapp.model.MessageGreet;
import com.bridzelabz.greetingapp.model.User;
import com.bridzelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingMsg")
public class GreetingRepoController {
    private static final String template ="Hello %s!";
    private final AtomicLong counter =new AtomicLong();

    @Autowired
    private IGreetingService greetingService;


    @GetMapping(value = {"", "/", "/home"})
    public MessageGreet greeting(@RequestParam(value = "name",defaultValue = "World") String name){
          User user =new User();
          user.setFirstName(name);
          return greetingService.addGreeting(user);

    }

}
