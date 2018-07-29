package com.christuniversity.careercounsellingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christuniversity.careercounsellingbackend.dao.DimensionDao;
import com.christuniversity.careercounsellingbackend.model.Dimension;



public class DimensionTest 
{
	public static void main(String a[])
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.christuniversity.*");
	context.refresh();
	
	DimensionDao dimensionDao=(DimensionDao)context.getBean("dimensionDao");
	Dimension dime=(Dimension)context.getBean("dimension");
	System.out.println(11111111111l);
	dime.setDime_name("Dimension A");
	dime.setDime_details("asdfasdfsdfasd");
	if(dimensionDao.saveorupdate(dime))
	{
		System.out.println("successful");
	}
	else
	{
		System.out.println("sorry");
	}
	
	}
	
}
