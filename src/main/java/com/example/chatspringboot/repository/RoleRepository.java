package com.example.chatspringboot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chatspringboot.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
