package com.example.springboot.hibernate.hibernate_mapping.M2M.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.hibernate.hibernate_mapping.M2M.domain.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long>{

}
