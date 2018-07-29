package com.christuniversity.careercounsellingbackend;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christuniversity.careercounsellingbackend.dao.SchoolDao;
import com.christuniversity.careercounsellingbackend.dao.UserDao;
import com.christuniversity.careercounsellingbackend.model.Authentication;
import com.christuniversity.careercounsellingbackend.model.Report;
import com.christuniversity.careercounsellingbackend.model.School;
import com.christuniversity.careercounsellingbackend.model.User;

public class UserTest {

	public static void main(String a[])
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.christuniversity.*");
	context.refresh();
	SchoolDao schoolDao=(SchoolDao)context.getBean("schoolDao");
	School s=(School)context.getBean("school");
	UserDao userDao=(UserDao)context.getBean("userDao");
	User u=(User)context.getBean("user");
	Authentication au=(Authentication)context.getBean("authentication");
//	u.setName("Sanjay");
//	u.setCla("8");
//	u.setLname("Vincent");
//	u.setPwd("123456");
//	u.setNumber("9902206832");
//	u.setRegister(new Date());
//	u.setSchool(s);
//	u.setRol("24");
//	u.setSection('A');
////	u.setInsti("Christ University");
//	u.setEmail("svsankod@gmail.com");
////	u.setPass("not123456");
//	au.setRolename("ROLE_ADMIN");
//	au.setUsername(u.getEmail());
	u.setAut(au);
	//ReportDao reportDao=(ReportDao)context.getBean("reportDao");
	
	Report r=(Report)context.getBean("report");
	r.setDimensionname("ferf");
	u.setReport(r);
	if(userDao.saveorupdate(u))
	{
		System.out.println(" User successful");
	}
	else
	{
		System.out.println("user_sorry");
	}
	
	}
}
