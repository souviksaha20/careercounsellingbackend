package com.christuniversity.careercounsellingbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Subject 
{
	@Id
	private String sub_id;
	private String sub_name;
	private String sub_desc;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "User_Subjects",joinColumns = {
//	@JoinColumn(name = "User_id", nullable = false, updatable = false) },
//	inverseJoinColumns = { @JoinColumn(name = "Subject_id",
//					nullable = false, updatable = false) })
//	private List<Subject>  subjects;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "User_Subjects",
//			joinColumns={@JoinColumn(name = "Subject_id")},
//			inverseJoinColumns={@JoinColumn(name = "User_id")})
//	private User user;
	
	public Subject() {
		this.sub_id = "Subject" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getSub_id() {
		return sub_id;
	}
	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getSub_desc() {
		return sub_desc;
	}
	public void setSub_desc(String sub_desc) {
		this.sub_desc = sub_desc;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
}
