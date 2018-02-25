package com.workshopmongodb.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workshopmongodb.domain.User;
import com.workshopmongodb.repositories.UserRepository;

@Component
public class Inserts {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		addUsers();
	}

	private void addUsers() {
		userRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.save(Arrays.asList(maria, alex, bob));
	}
	
}
