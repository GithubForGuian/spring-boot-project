package com.springboot.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@EnableAutoConfiguration
@Entity
@Table(name = "s_user", catalog = "test")//code11
public class SUser implements java.io.Serializable {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private Date dob;
	private Set<SRole> SRoles = new HashSet<SRole>(0);// Code12

	public SUser() {
	}

	public SUser(String name, String email, String password, Date dob, Set<SRole> SRoles) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.SRoles = SRoles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")
	public Set<SRole> getSRoles() {
		return this.SRoles;
	}

	public void setSRoles(Set<SRole> SRoles) {
		this.SRoles = SRoles;
	}

}

