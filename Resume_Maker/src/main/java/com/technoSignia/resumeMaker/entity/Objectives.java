package com.technoSignia.resumeMaker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "objectives")
public class Objectives {

	@Id
	@Column(name = "id", length = 45)
	Long id;

	@Column(name = "name", length = 45)
	String name;
}
