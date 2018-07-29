package com.christuniversity.careercounsellingbackend.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;



@Entity
@Table
@Component
public class User 
{
	@Id
	private String User_id;
	private String Fname;
	private String Lname;
	@Column(name = "email",length = 250, nullable = false,unique = false)
	@NotEmpty(message = "Email cannot be left empty.")
	private String email_id;
	private String password;
	private String phone_no;
	private String stud_class;
	private Date std_reg_date;
	private String section="";
	private String takentest="No";
	@OneToOne(cascade = CascadeType.ALL)
    Authentication aut;
	@OneToOne(cascade = CascadeType.ALL)
	Report report;
	@ManyToOne
	School school;
	private String roll_no;
	private String stud_uniq_code;
	private int progress;

	public User() 
	{
		std_reg_date=new Date();
		this.User_id = "User" + UUID.randomUUID().toString().substring(30).toUpperCase();	
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String user_id) {
		User_id = user_id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getStud_class() {
		return stud_class;
	}

	public void setStud_class(String stud_class) {
		this.stud_class = stud_class;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Authentication getAut() {
		return aut;
	}

	public Date getStd_reg_date() {
		return std_reg_date;
	}

	public void setStd_reg_date(Date std_reg_date) {
		this.std_reg_date = std_reg_date;
	}

	public void setAut(Authentication aut) {
		this.aut = aut;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}

	public String getStud_uniq_code() {
		return stud_uniq_code;
	}

	public void setStud_uniq_code(String stud_uniq_code) {
		this.stud_uniq_code = stud_uniq_code;
	}

	public String getTakentest() {
		return takentest;
	}

	public void setTakentest(String takentest) {
		this.takentest = takentest;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	
}
