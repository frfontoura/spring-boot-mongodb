package com.workshopmongodb.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.domain.User;
import com.workshopmongodb.repositories.PostRepository;
import com.workshopmongodb.repositories.UserRepository;

@Component
public class Inserts {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postReposiroty;
	
	@PostConstruct
	public void init() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

		userRepository.save(Arrays.asList(maria, alex, bob));
		postReposiroty.save(Arrays.asList(post1, post2));
	}


	
}
