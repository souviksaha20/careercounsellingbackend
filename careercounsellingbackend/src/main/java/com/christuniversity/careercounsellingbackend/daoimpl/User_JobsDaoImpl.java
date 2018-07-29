package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.User_JobsDao;
import com.christuniversity.careercounsellingbackend.model.User_Jobs;

@Repository("user_JobsDao")
@EnableTransactionManagement
public class User_JobsDaoImpl implements User_JobsDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public User_JobsDaoImpl(SessionFactory sessionFactory) 
	{
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveorupdate(User_Jobs x) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(x); 
			return true;
		}
		catch (Exception e) {
			System.out.println("attempt to create delete event with null entity");
			return false;
		}
	}
	
	@Transactional
	public User_Jobs getUser_Jobs(String id) {
		String hql = "from User_Jobs where userjob_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User_Jobs> list2 =(List<User_Jobs>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}
	
	@Transactional
	public boolean delete(User_Jobs x) {
		try {
			sessionFactory.getCurrentSession().delete(x); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
	}

	@Transactional
	public List<User_Jobs> User_Jobs() {
		@SuppressWarnings("unchecked")
		List<User_Jobs> userjobs = (List<User_Jobs>)sessionFactory.openSession().createCriteria(User_Jobs.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return userjobs;
	}
	
	@Transactional
	public User_Jobs getUserJobsByJobnUser(String id,String uid)
	{
		String hql = "from User_Jobs where job_id='" +id+ "'and user_id='" +uid+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User_Jobs> list2 =(List<User_Jobs>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		}
	}
	@Transactional 
    public List<User_Jobs> getJobsByUser(String id)
    {
		String hql = "from User_Jobs where user_id='" +id+ "'";
		  Query q = sessionFactory.getCurrentSession().createQuery(hql);
		  @SuppressWarnings("unchecked")
		  List<User_Jobs> list2 =(List<User_Jobs>)q.list();
		  if (list2 == null || list2.isEmpty()) {
		   return null;
		  } 
		  else 
		  {     
		   return list2;
		  }
    }
}
