package com.chase.example.useraccesspasswords.repos;

import org.springframework.data.repository.CrudRepository;

import com.chase.example.useraccesspasswords.pojos.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserName(String username);
}
