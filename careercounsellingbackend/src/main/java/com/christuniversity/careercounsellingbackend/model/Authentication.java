package com.christuniversity.careercounsellingbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Authentication  
{
	@Id
	private String roleId;
	private String rolename;
	@Column(name = "username",length = 250, nullable = false,unique = true)
	@NotEmpty(message = "Student_Uniq_Code problem")
	private String username;
	public String enabled="false";
    public Authentication() {
		
		this.roleId ="AUTH"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getEnabled() {
		return enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String isEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
    
	

}
