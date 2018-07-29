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
public class Dimension 
{
	@Id
	private String Dime_id;
	private int noofques=8;
	@Column(name = "dime_name", length = 100,nullable = false,unique = true)
	@NotEmpty(message = "Please Enter the Dimension name")
	private String dime_name;
	@Column(name = "dime_details", length = 500)
	private String dime_details;
	
//	@OneToMany(fetch = FetchType.LAZY,mappedBy="dimension")
//	private List<Question> question;
	
	public Dimension()
	{
		this.Dime_id = "Dime" + UUID.randomUUID().toString().substring(30).toUpperCase();	
	}

	public String getDime_id() {
		return Dime_id;
	}

	public void setDime_id(String dime_id) {
		Dime_id = dime_id;
	}

	public int getNoofques() {
		return noofques;
	}

	public void setNoofques(int noofques) {
		this.noofques = noofques;
	}

	public String getDime_name() {
		return dime_name;
	}

	public void setDime_name(String dime_name) {
		this.dime_name = dime_name;
	}

	public String getDime_details() {
		return dime_details;
	}

	public void setDime_details(String dime_details) {
		this.dime_details = dime_details;
	}
	
}
