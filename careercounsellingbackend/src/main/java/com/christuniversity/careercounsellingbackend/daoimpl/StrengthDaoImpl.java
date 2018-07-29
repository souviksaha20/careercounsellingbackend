package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.StrengthDao;
import com.christuniversity.careercounsellingbackend.model.Strength;

@Repository("strengthDao")
@EnableTransactionManagement
public class StrengthDaoImpl implements StrengthDao
{

	
	@Autowired
	private SessionFactory sessionFactory;
	public StrengthDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(Strength s) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(s); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Strength getStrengths(String id) {
		String hql = "from Strength where str_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Strength> list2 =(List<Strength>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}

	@Transactional
	public boolean delete(Strength s) {
		try {
			sessionFactory.getCurrentSession().delete(s); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
	}
	@Transactional 
	public List<Strength> Strengths()
    {
		 @SuppressWarnings("unchecked")
			List<Strength> strengthss = (List<Strength>)sessionFactory.openSession().createCriteria(Strength.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return strengthss;
    }
}
