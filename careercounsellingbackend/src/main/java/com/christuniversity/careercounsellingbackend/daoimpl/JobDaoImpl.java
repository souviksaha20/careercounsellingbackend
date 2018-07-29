package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.JobDao;
import com.christuniversity.careercounsellingbackend.model.Job;
import com.christuniversity.careercounsellingbackend.model.User;

@Repository("jobDao")
@EnableTransactionManagement
public class JobDaoImpl implements JobDao
{

	@Autowired
	private SessionFactory sessionFactory;
	public JobDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(Job j) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(j); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Job getJobs(String id) {
		String hql = "from Job where job_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Job> list2 =(List<Job>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}

	@Transactional
	public boolean delete(Job j) {
		try {
			sessionFactory.getCurrentSession().delete(j); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
	}
	@Transactional 
	public List<Job> Jobs()
    {
		 @SuppressWarnings("unchecked")
			List<Job> jobss = (List<Job>)sessionFactory.openSession().createCriteria(Job.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return jobss;
    }

	@Transactional
	public boolean deleteUser_job(String x, String y) {
		String q1="from Job where User_id='"+x+"'and Job_id='"+y+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		sessionFactory.getCurrentSession().delete(w.list().get(0));
		return false;
	}
	@Transactional
	public boolean deleteUser_job1(String x)
	{
		String q1="from Job where User_id='"+x+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		sessionFactory.getCurrentSession().delete(w);
		System.out.println(12);
		return false;
		
	}

//	String q1="from Job where User_id='"+x+"'and Job_id='"+y+"'";
//	Query w = sessionFactory.getCurrentSession().createQuery(q1);
//	sessionFactory.getCurrentSession().delete(w.list().get(0));
//	@Transactional
//	public User isvalid(String email, String pwd) {
//	 System.out.println(email+" "+pwd);
//		String q1="from User where email='"+email+"'and pwd='"+pwd+"'";
//		Query w = sessionFactory.getCurrentSession().createQuery(q1);
//		List<User> list = (List<User>) w.list();
//		if (list == null || list.isEmpty()) 
//		{
//			return null;
//		}
//		   return list.get(0);
//	   }
}
