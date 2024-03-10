package com.example.chatspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.chatspringboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User findUserByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.username <> ?1")
	public List<User> findAllByUsernameNot(String username);
}
