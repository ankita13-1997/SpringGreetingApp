package com.bridzelabz.greetingapp.repository;

import com.bridzelabz.greetingapp.model.MessageGreet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<MessageGreet,Long> {

}
