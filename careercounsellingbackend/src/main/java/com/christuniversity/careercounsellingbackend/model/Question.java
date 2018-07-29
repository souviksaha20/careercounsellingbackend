package com.christuniversity.careercounsellingbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;



@Entity
@Table
@Component
public class Question 
{
  @Id
  private String que_id;
  @Column(name = "question", length = 100,nullable = false,unique = true)
  @NotEmpty(message = "Please Enter The question name")
  private String question;
  @ManyToOne(fetch =FetchType.EAGER)
  @JoinColumn(name = "dimension_id")
  private Dimension dimension;
  
  
public Question() {
	this.que_id = "question" + UUID.randomUUID().toString().substring(30).toUpperCase();
}


public String getQue_id() {
	return que_id;
}


public void setQue_id(String que_id) {
	this.que_id = que_id;
}


public String getQuestion() {
	return question;
}


public void setQuestion(String question) {
	this.question = question;
}


public Dimension getDimension() {
	return dimension;
}


public void setDimension(Dimension dimension) {
	this.dimension = dimension;
}

  
}
