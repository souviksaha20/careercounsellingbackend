package com.christuniversity.careercounsellingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christuniversity.careercounsellingbackend.dao.DimensionDao;
import com.christuniversity.careercounsellingbackend.dao.QuestionDao;
import com.christuniversity.careercounsellingbackend.model.Dimension;
import com.christuniversity.careercounsellingbackend.model.Question;

public class QuestionTest 
{
	public static void main(String a[])
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.christuniversity.*");
	context.refresh();
	
	DimensionDao dimensionDao=(DimensionDao)context.getBean("dimensionDao");
	Dimension dime2=(Dimension)context.getBean("dimension");
	dime2=dimensionDao.getDimensions("Dime3B3D5B");
	QuestionDao questionDao=(QuestionDao)context.getBean("questionDao");
	Question dime=(Question)context.getBean("question");
	
	dime.setQuestion("What Is Your Name");
	dime.setDimension(dime2);
	if(questionDao.saveorupdate(dime))
	{
		System.out.println("successful");
	}
	else
	{
		System.out.println("sorry");
	}
	
	}
	
}
