package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.UserDao;
import com.christuniversity.careercounsellingbackend.model.User;


@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(User c)
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(c); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional 
	public User getUsers(String id)
	{
		 String hql = "from User where User_id='" +id+ "'";
			Query q = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<User> list2 =(List<User>)q.list();
			if (list2 == null || list2.isEmpty()) {
				return null;
			} 
			else 
			{	    
				return list2.get(0);
				
			} 
	}
    @Transactional 
    public boolean delete(User c)
    {
    	try {
			sessionFactory.getCurrentSession().delete(c); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
    }
	@Transactional 
    public List<User> Users()
    {
		 @SuppressWarnings("unchecked")
			List<User> userList = (List<User>)sessionFactory.openSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return userList;
    }
	 @Transactional
		public User isvalid(String email, String pwd) {
		 System.out.println(email+" "+pwd);
			String q1="from User where email='"+email+"'and pwd='"+pwd+"'";
			Query w = sessionFactory.getCurrentSession().createQuery(q1);
			List<User> list = (List<User>) w.list();
			if (list == null || list.isEmpty()) 
			{
				return null;
			}
			   return list.get(0);
		   }
	 
	@Transactional
	public User getUserByUniqCode(String id) {
		String hql = "from User where stud_uniq_code='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list2 =(List<User>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{
			return list2.get(0);		
		}
	}

}
