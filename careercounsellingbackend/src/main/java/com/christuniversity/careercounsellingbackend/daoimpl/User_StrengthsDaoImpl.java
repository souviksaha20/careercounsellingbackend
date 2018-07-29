package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.christuniversity.careercounsellingbackend.dao.User_StrengthsDao;
import com.christuniversity.careercounsellingbackend.model.User_Strengths;

public class User_StrengthsDaoImpl implements User_StrengthsDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public User_StrengthsDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean saveorupdate(User_Strengths x) {
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
	public User_Strengths getUser_Strengths(String id) {
		String hql = "from User_Strengths where userstr_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User_Strengths> list2 =(List<User_Strengths>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}
	
	@Transactional
	public boolean delete(User_Strengths x) {
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
	public List<User_Strengths> User_Strengths() {
		@SuppressWarnings("unchecked")
		List<User_Strengths> userstrengths = (List<User_Strengths>)sessionFactory.openSession().createCriteria(User_Strengths.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return userstrengths;
	}
	@Transactional
	public User_Strengths getUserStrengthsByStrnUser(String id,String uid)
	{
		String hql = "from User_Strengths where strength_id='" +id+ "' and user_id='"+uid+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User_Strengths> list2 =(List<User_Strengths>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
		}
	}
	@Transactional 
    public List<User_Strengths> getStrByUser(String id)
    {
		String hql = "from User_Strengths where user_id='" +id+ "'";
		  Query q = sessionFactory.getCurrentSession().createQuery(hql);
		  @SuppressWarnings("unchecked")
		  List<User_Strengths> list2 =(List<User_Strengths>)q.list();
		  if (list2 == null || list2.isEmpty()) {
		   return null;
		  } 
		  else 
		  {     
		   return list2;
		  }
    }
}
