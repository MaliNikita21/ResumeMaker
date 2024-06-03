package com.technoSignia.resumeMaker.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoSignia.resumeMaker.entity.User;

public interface UserDao extends JpaRepository<User, UUID> {

	Optional<User> findOneByEmailAndPassword(String email, String password);

	Optional<User> findByEmail(String email);
}
