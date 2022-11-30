package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	/* just this can instantiate an object repository with some operations
	spring JPA already have an standard implementation of some operations */
}
