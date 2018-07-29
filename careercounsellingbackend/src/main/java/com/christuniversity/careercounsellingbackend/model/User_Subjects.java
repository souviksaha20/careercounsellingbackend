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
public class User_Subjects 
{
	@Id
	String usersub_id;
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;
	@OneToOne
	@JoinColumn(name = "subject_id",nullable = false)
	Subject subject;
	
	public User_Subjects()
	{
		this.usersub_id = "Usersub_id" + UUID.randomUUID().toString().substring(30).toUpperCase();	
	}
	
	public String getUsersub_id() {
		return usersub_id;
	}
	public void setUsersub_id(String usersub_id) {
		this.usersub_id = usersub_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
