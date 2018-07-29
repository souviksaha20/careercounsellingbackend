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
public class User_Jobs 
{
	@Id
	String userjob_id;
	@OneToOne
	@JoinColumn(name = "user_id")
	User user;
	@OneToOne
	@JoinColumn(name = "job_id",nullable = false)
	Job job;
	
	public User_Jobs()
	{
		this.userjob_id = "Userjob_id" + UUID.randomUUID().toString().substring(30).toUpperCase();	
	}
	
	public String getUserjob_id() {
		return userjob_id;
	}
	public void setUserjob_id(String userjob_id) {
		this.userjob_id = userjob_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
}