package com.example.springboot.hibernate.Hibernate_Mapping;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.hibernate.Hibernate_Mapping.domain.Gender;
import com.example.springboot.hibernate.Hibernate_Mapping.domain.User;
import com.example.springboot.hibernate.Hibernate_Mapping.domain.UserProfile;
import com.example.springboot.hibernate.Hibernate_Mapping.repository.UserProfileRepo;
import com.example.springboot.hibernate.Hibernate_Mapping.repository.UserRepo;


@SpringBootApplication
public class HibernateMappingApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		// clean-up the databasetables
		userRepo.deleteAllInBatch();
		userProfileRepo.deleteAllInBatch();
		
		//user instance
		 User user = new User("Punith", "Rajkumar", "punith@star.com",
	                "MY_SECRET_PASSWORD");
		 
		 Calendar dateOfBirth = Calendar.getInstance();
	        dateOfBirth.set(1975, 3, 15);
	        
	        // userProfile instance
	        UserProfile userProfile = new UserProfile("123456789", Gender.MALE, dateOfBirth.getTime(),
	              "Banglore");
	        System.out.println(dateOfBirth.getTime());
	     // Setting child reference(userProfile) in parent entity(user)
	        user.setUserProfile(userProfile);

	        // Setting parent reference(user) in child entity(userProfile)
	        userProfile.setUser(user);

	        // Save Parent Reference (which will save the child as well)
	        userRepo.save(user);

	        
	}
}
