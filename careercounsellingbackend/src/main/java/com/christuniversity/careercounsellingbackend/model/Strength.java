package com.christuniversity.careercounsellingbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Strength 
{
	@Id
	private String str_id;
	private String str_name;
	private String str_desc;
//	@ManyToOne
//	@JoinTable(name = "User_Strengths",
//			joinColumns={@JoinColumn(name = "Strength_id")},
//			inverseJoinColumns={@JoinColumn(name = "User_id")})
//	private User user;
	
	public Strength() {
		this.str_id = "Strength" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getStr_id() {
		return str_id;
	}
	public void setStr_id(String str_id) {
		this.str_id = str_id;
	}
	public String getStr_name() {
		return str_name;
	}
	public void setStr_name(String str_name) {
		this.str_name = str_name;
	}
	public String getStr_desc() {
		return str_desc;
	}
	public void setStr_desc(String str_desc) {
		this.str_desc = str_desc;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
}
