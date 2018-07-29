package com.christuniversity.careercounsellingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christuniversity.careercounsellingbackend.dao.StrengthDao;
import com.christuniversity.careercounsellingbackend.dao.UserDao;
import com.christuniversity.careercounsellingbackend.model.Strength;
import com.christuniversity.careercounsellingbackend.model.User;

public class StrengthTest {
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.christuniversity.*");
		context.refresh();
		UserDao userDao=(UserDao)context.getBean("userDao");
		User u=(User)context.getBean("user");
		u=userDao.getUsers("User13E597");
		StrengthDao strengthDao=(StrengthDao)context.getBean("strengthDao");
		Strength s=(Strength)context.getBean("strength");
		s.setStr_name("Confident");
		s.setStr_desc("you got the balls?");
//		s.setUser(u);
		if(strengthDao.saveorupdate(s))
			System.out.println("Strength successful");
		else
			System.out.println("sorry");
	}
}
