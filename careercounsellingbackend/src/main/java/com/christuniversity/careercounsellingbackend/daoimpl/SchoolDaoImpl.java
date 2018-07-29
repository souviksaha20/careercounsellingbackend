package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.SchoolDao;
import com.christuniversity.careercounsellingbackend.model.School;


@Repository("schoolDao")
@EnableTransactionManagement
public class SchoolDaoImpl implements SchoolDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	public SchoolDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(School s) {
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
	public School getSchools(String id) {
		String hql = "from School where school_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<School> list2 =(List<School>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}

	@Transactional
	public boolean delete(School s) {
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
	public List<School> Schools()
    {
		 @SuppressWarnings("unchecked")
			List<School> Schoolss = (List<School>)sessionFactory.openSession().createCriteria(School.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return Schoolss;
    }
	
	
	
	
}
