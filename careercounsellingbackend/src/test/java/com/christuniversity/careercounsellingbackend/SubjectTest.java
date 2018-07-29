package com.christuniversity.careercounsellingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christuniversity.careercounsellingbackend.dao.SubjectDao;
import com.christuniversity.careercounsellingbackend.dao.UserDao;
import com.christuniversity.careercounsellingbackend.model.Subject;
import com.christuniversity.careercounsellingbackend.model.User;

public class SubjectTest
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.christuniversity.*");
		context.refresh();
		UserDao userDao=(UserDao)context.getBean("userDao");
		User u=(User)context.getBean("user");
		u=userDao.getUsers("User13E597");
		SubjectDao subjectDao=(SubjectDao)context.getBean("subjectDao");
		Subject su=(Subject)context.getBean("subject");
		Subject su1=new Subject();
		Subject su2=new Subject();
		Subject su3=new Subject();
//		Subject su4=(Subject)context.getBean("subject");
		su1.setSub_name("Math");
		su1.setSub_desc("Lot of problems");
//		su1.setUser(u);
		if(subjectDao.saveorupdate(su1))
			System.out.println("subject1 successful");
		else
			System.out.println("sorry");
		
		su2.setSub_name("Computer Science");
		su2.setSub_desc("You the hackerman boi!");
//		su2.setUser(u);
		if(subjectDao.saveorupdate(su2))
			System.out.println("subject2 successful");
		else
			System.out.println("sorry");
		
		su3.setSub_name("English");
		su3.setSub_desc("Shakespeare in the making?");
//		su3.setUser(u);
		if(subjectDao.saveorupdate(su3))
			System.out.println("subject3 successful");
		else
			System.out.println("sorry");
		
		su.setSub_name("History");
		su.setSub_desc("Learn from your ancestors mistakes");
//		su.setUser(u);
		if(subjectDao.saveorupdate(su))
			System.out.println("subject successful");
		else
			System.out.println("sorry");
	}
}
