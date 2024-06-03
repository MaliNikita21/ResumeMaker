package com.technoSignia.resumeMaker.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoSignia.resumeMaker.entity.Project;

public interface ProjectDao extends JpaRepository<Project, UUID>{

}
