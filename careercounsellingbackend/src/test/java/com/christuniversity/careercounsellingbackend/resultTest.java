package com.christuniversity.careercounsellingbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christuniversity.careercounsellingbackend.dao.QuestionDao;
import com.christuniversity.careercounsellingbackend.dao.ResultDao;
import com.christuniversity.careercounsellingbackend.dao.UserDao;
import com.christuniversity.careercounsellingbackend.model.Question;
import com.christuniversity.careercounsellingbackend.model.Report;
import com.christuniversity.careercounsellingbackend.model.Result;
import com.christuniversity.careercounsellingbackend.model.User;

public class resultTest {
	public static void main(String a[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.christuniversity.*");
		context.refresh();
		UserDao userDao=(UserDao)context.getBean("userDao");
		User u=(User)context.getBean("user");
		QuestionDao questionDao=(QuestionDao)context.getBean("questionDao");
		Question q=(Question)context.getBean("question");
		u=userDao.getUsers("User429926");
//		System.out.println(u.getReport().getRep_id());
		q=questionDao.getQuestions("questionD30615");
//		System.out.println(q.getDimension().getDime_id());
		ResultDao resultDao=(ResultDao)context.getBean("resultDao");
		Result r=(Result)context.getBean("result");
//		r=resultDao.getResults("");
//		ReportDao reportDao=(ReportDao)context.getBean("reportDao");
//		Report rp=(Report)context.getBean("report");
		Report repor=u.getReport();
		int x=243;
		repor.setDimensionname("ngtir");
		repor.setHighestmarks("dijrf");
		u.setReport(repor);
//		repor=resultDao.setRepo("hola", Integer.toString(x), repor.getRep_id());
//		repor.setDimensionname("jhgjh");
//		repor.setHighestmarks("ho");
//		r.setReport(report);
		r.setReport(repor);
		System.out.println(repor.getDimensionname());
		System.out.println(repor.getHighestmarks());
		r.setQuestion(q);
		r.setAnswer("Yes");
		if(userDao.saveorupdate(u))
		{
			if(resultDao.saveorupdate(r))
				System.out.println("result successful");
		}
		else
		{
			System.out.println("sorry");
		}
	}
}
