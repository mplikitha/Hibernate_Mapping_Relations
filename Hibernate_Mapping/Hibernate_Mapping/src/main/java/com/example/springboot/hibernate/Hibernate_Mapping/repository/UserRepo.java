package com.example.springboot.hibernate.Hibernate_Mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.hibernate.Hibernate_Mapping.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
