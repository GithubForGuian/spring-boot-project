package com.springboot.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SRoleRepositoryImpl {

	@Autowired
	@Qualifier("entityManagerSecondary")
	private EntityManager entityManager;
	
}
