package com.christuniversity.careercounsellingbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class User_Strengths 
{
	@Id
	String userstr_id;
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;
	@OneToOne
	@JoinColumn(name = "strength_id",nullable = false)
	Strength strength;
	
	public User_Strengths()
	{
		this.userstr_id = "Userstr_id" + UUID.randomUUID().toString().substring(30).toUpperCase();	
	}
	
	public String getUserstr_id() {
		return userstr_id;
	}
	public void setUserstr_id(String userstr_id) {
		this.userstr_id = userstr_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Strength getStrength() {
		return strength;
	}
	public void setStrength(Strength strength) {
		this.strength = strength;
	}
}
