package com.christuniversity.careercounsellingbackend.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class School 
{
	@Id
	private String school_id;
	private String school_name;
	private String address1;
	private String address2;
	private String state;
	private String city;
	private String pincode;
	private String no_of_studs;
    private int count=0;
    private String enable="true";
    private Date register_from;
	private Date register_to;
	private String scl_uniq_code;
	public School()
	{
		Calendar cal = Calendar.getInstance();
		register_from = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		register_to= cal.getTime();
		this.school_id ="school"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	
	public String getScl_uniq_code() {
		return scl_uniq_code;
	}
	public void setScl_uniq_code(String scl_uniq_code) {
		this.scl_uniq_code = scl_uniq_code;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getNo_of_studs() {
		return no_of_studs;
	}
	public void setNo_of_studs(String no_of_studs) {
		this.no_of_studs = no_of_studs;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public Date getRegister_from() {
		return register_from;
	}
	public void setRegister_from(Date register_from) {
		this.register_from = register_from;
	}
	public Date getRegister_to() {
		return register_to;
	}
	public void setRegister_to(Date register_to) {
		this.register_to = register_to;
	}
}
