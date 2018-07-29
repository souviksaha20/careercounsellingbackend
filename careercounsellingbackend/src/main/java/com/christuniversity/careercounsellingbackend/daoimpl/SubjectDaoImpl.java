package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.SubjectDao;
import com.christuniversity.careercounsellingbackend.model.Subject;

@Repository("subjectDao")
@EnableTransactionManagement
public class SubjectDaoImpl implements SubjectDao
{

	@Autowired
	private SessionFactory sessionFactory;
	public SubjectDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(Subject su)
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(su); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Subject getSubjects(String id) {
		String hql = "from Subject where sub_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Subject> list2 =(List<Subject>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}

	@Transactional
	public boolean delete(Subject su) {
		try {
			sessionFactory.getCurrentSession().delete(su); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
	}
	@Transactional 
	public List<Subject> Subjects()
    {
		 @SuppressWarnings("unchecked")
			List<Subject> subjectss = (List<Subject>)sessionFactory.openSession().createCriteria(Subject.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return subjectss;
    }
}
