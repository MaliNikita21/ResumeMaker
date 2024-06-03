package com.technoSignia.resumeMaker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technoSignia.resumeMaker.entity.Employment;

@Repository
public interface EmploymentDao extends JpaRepository<Employment, Long> {

}
