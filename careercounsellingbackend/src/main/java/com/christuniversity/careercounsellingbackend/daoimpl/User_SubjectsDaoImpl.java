package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.User_SubjectsDao;
import com.christuniversity.careercounsellingbackend.model.User_Subjects;

@Repository("user_SubjectsDao")
@EnableTransactionManagement
public class User_SubjectsDaoImpl implements User_SubjectsDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public User_SubjectsDaoImpl(SessionFactory sessionFactory) 
	{
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveorupdate(User_Subjects x) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(x); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public User_Subjects getUser_Subjects(String id) {
		String hql = "from User_Subjects where usersub_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User_Subjects> list2 =(List<User_Subjects>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}
	
	@Transactional
	public boolean delete(User_Subjects x) {
		try {
			sessionFactory.getCurrentSession().delete(x); 
			return true;
		}
		catch (Exception e) {
			System.out.println("attempt to create delete event with null entity");
			return false;
		}  
	}
	
	@Transactional
	public List<User_Subjects> User_Subjects() {
		@SuppressWarnings("unchecked")
		List<User_Subjects> usersubjects = (List<User_Subjects>)sessionFactory.openSession().createCriteria(User_Subjects.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return usersubjects;
	}
	@Transactional
	public User_Subjects getUserSubjectsBySubnUser(String id, String uid)
	{
		String hql = "from User_Subjects where subject_id='" +id+ "' and user_id='" +uid+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User_Subjects> list2 =(List<User_Subjects>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
		}
	}
	@Transactional 
    public List<User_Subjects> getSubByUser(String id)
    {
		String hql = "from User_Subjects where user_id='" +id+ "'";
		  Query q = sessionFactory.getCurrentSession().createQuery(hql);
		  @SuppressWarnings("unchecked")
		  List<User_Subjects> list2 =(List<User_Subjects>)q.list();
		  if (list2 == null || list2.isEmpty()) {
		   return null;
		  } 
		  else 
		  {     
		   return list2;
		  }
    }
}
