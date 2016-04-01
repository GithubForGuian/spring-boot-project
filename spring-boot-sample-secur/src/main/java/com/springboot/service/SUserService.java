package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.springboot.domain.SUser;
import com.springboot.repository.SUserRepository;

@EnableAutoConfiguration
@Service("suserService")
public class SUserService {

	@Autowired
	private SUserRepository suserRepository;//code10

	public List<SUser> findAll() {
		return suserRepository.findAll();
	}

	public SUser create(SUser user) {
		return suserRepository.save(user);
	}

	public SUser findUserById(int id) {
		return suserRepository.findOne(id);
	}

	public SUser login(String email, String password) {
		return suserRepository.findByEmailAndPassword(email, password);
	}

	public SUser update(SUser user) {
		return suserRepository.save(user);
	}

	public void deleteUser(int id) {
		suserRepository.delete(id);
	}

	public SUser findUserByEmail(String email) {
		return suserRepository.findUserByEmail(email);
	}

}
