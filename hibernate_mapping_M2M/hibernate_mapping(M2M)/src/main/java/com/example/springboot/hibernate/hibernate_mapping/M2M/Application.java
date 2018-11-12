package com.example.springboot.hibernate.hibernate_mapping.M2M;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springboot.hibernate.hibernate_mapping.M2M.domain.Post;
import com.example.springboot.hibernate.hibernate_mapping.M2M.domain.Tag;
import com.example.springboot.hibernate.hibernate_mapping.M2M.repo.PostRepo;
import com.example.springboot.hibernate.hibernate_mapping.M2M.repo.TagRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private TagRepo tagRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		postRepo.deleteAllInBatch();
		tagRepo.deleteAllInBatch();
		
		// Create a Post
        Post post = new Post("title",
                "description",
                "content");
//        Post post1 = new Post("title1",
//                "description1",
//                "content1");


        // Create  tags
        Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("Hibernate");
        Tag tag3=new Tag("Mapping");


        // Add tag references in the post
        post.getTags().add(tag1);
        post.getTags().add(tag2);
        post.getTags().add(tag3);

        // Add post reference in the tags
        tag1.getPosts().add(post);
        tag2.getPosts().add(post);
        tag3.getPosts().add(post);
        postRepo.save(post);

	}
}
