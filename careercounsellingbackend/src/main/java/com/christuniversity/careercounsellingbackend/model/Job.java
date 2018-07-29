package com.christuniversity.careercounsellingbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Job 
{
	@Id
	private String job_id;
	private String job_name;
	private String job_desc;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "User_DreamJobs",joinColumns = {
//	@JoinColumn(name = "User_id", nullable = false, updatable = false) },
//	inverseJoinColumns = { @JoinColumn(name = "Jobs_id",
//					nullable = false, updatable = false) })
//	private List<Job>  jobs;
	
//	@ManyToOne
//	@JoinTable(name = "User_DreamJobs",
//			joinColumns={@JoinColumn(name = "Job_id")},
//			inverseJoinColumns={@JoinColumn(name = "User_id")})
//	private User user;
	
	public Job() {
		this.job_id = "Job" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getJob_desc() {
		return job_desc;
	}

	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

//	public List<Job> getJobs() {
//		return jobs;
//	}
//
//	public void setJobs(List<Job> jobs) {
//		this.jobs = jobs;
//	}

	
}
