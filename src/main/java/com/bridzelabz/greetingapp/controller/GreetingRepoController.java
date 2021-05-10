package com.bridzelabz.greetingapp.controller;

import com.bridzelabz.greetingapp.model.MessageGreet;
import com.bridzelabz.greetingapp.model.User;
import com.bridzelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingmsg")
public class GreetingRepoController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;


    @PostMapping("/post")
    public MessageGreet greeting(@RequestParam(value = "name") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);

    }


    @PostMapping(value = {"/query"})
    public MessageGreet greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                                 @RequestParam(value = "lastName", defaultValue = "World") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);

    }

    @DeleteMapping("/querymsg")
    public String greeting(@RequestParam(value = "id") Long id) {
        MessageGreet messageGreet = new MessageGreet();
        greetingService.deleteById(id);
        return "the message of id " + id + " is deleted from repo";

    }

    @RequestMapping("/queryfind")
    public MessageGreet greetingToFindById(@RequestParam(value = "id") Long id) {
        return greetingService.findUsersById(id);
    }

    @GetMapping("/queryall")
    public List greetingToFindAll() {
        List<MessageGreet>allUsers=greetingService.getAllUsers();
        return allUsers;

    }
    @PutMapping("/put/{id}")
    public MessageGreet updateGreeting(@PathVariable long id,
                                       @RequestParam(value = "firstName") String firstName,
                                       @RequestParam(value = "lastName") String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.updateGreetingMessage(id,user);

    }



}