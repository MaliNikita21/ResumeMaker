package com.technoSignia.resumeMaker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoSignia.resumeMaker.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

	//User findByEmail_Id(String email_Id);
}
