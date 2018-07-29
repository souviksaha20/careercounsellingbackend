package com.christuniversity.careercounsellingbackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Report 
{
	@Id
	private String rep_id;
	private String dimensionname;
	private String highestmarks;
	
	
	public Report() {

		this.rep_id = "report" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getRep_id() {
		return rep_id;
	}
	public void setRep_id(String rep_id) {
		this.rep_id = rep_id;
	}
	public String getDimensionname() {
		return dimensionname;
	}
	public void setDimensionname(String dimensionname) {
		this.dimensionname = dimensionname;
	}
	public String getHighestmarks() {
		return highestmarks;
	}
	public void setHighestmarks(String highestmarks) {
		this.highestmarks = highestmarks;
	}
	
}
