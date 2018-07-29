package com.christuniversity.careercounsellingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christuniversity.careercounsellingbackend.dao.JobDao;
import com.christuniversity.careercounsellingbackend.dao.UserDao;
import com.christuniversity.careercounsellingbackend.model.Job;
import com.christuniversity.careercounsellingbackend.model.User;

public class JobTest
{
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.christuniversity.*");
		context.refresh();
		UserDao userDao=(UserDao)context.getBean("userDao");
		User u=(User)context.getBean("user");
		u=userDao.getUsers("User13E597");
		JobDao jobDao=(JobDao)context.getBean("jobDao");
		Job j=(Job)context.getBean("job");
		j.setJob_name("Engineer");
		j.setJob_desc("Worthless");
//		j.setUser(u);
		if(jobDao.saveorupdate(j))
			System.out.println("job successful");
		else
			System.out.println("sorry");
	}
}
