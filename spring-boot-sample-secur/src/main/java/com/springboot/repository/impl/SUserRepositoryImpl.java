package com.springboot.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository("sUserRepositoryImpl")
public class SUserRepositoryImpl {
	
	@Autowired
	@Qualifier("entityManagerPrimary")
	private EntityManager entityManager;

	public Page<Object[]> login(int id) {
		String hql = "select email from SUser u where u.id=:id";
		Query q = entityManager.createQuery(hql);
		q.setParameter("id", id).setFirstResult(0).setMaxResults(1);
		Page<Object[]> page = new PageImpl<Object[]>(q.getResultList(),
				new PageRequest(0, 1), 3);
		return page;

	}

}
