package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.QuestionDao;
import com.christuniversity.careercounsellingbackend.model.Question;

@Repository("questionDao")
@EnableTransactionManagement
public class QuestionDaoImpl implements QuestionDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public QuestionDaoImpl(SessionFactory sessionFactory) 
	{
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(Question c)
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
	public Question getQuestions(String id)
	{
		 String hql = "from Question where que_id='" +id+ "'";
			Query q = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Question> list2 =(List<Question>)q.list();
			if (list2 == null || list2.isEmpty()) {
				return null;
			} 
			else 
			{	    
				return list2.get(0);
				
			} 
	}
    @Transactional 
    public boolean delete(Question c)
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
    public List<Question> Questions()
    {
		 @SuppressWarnings("unchecked")
			List<Question> Brandss = (List<Question>)sessionFactory.openSession().createCriteria(Question.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return Brandss;
    }
	@Transactional
	public List<Question> getquesbyDim(String id)
	{
		String hql = "from Question where dimension='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Question> list2 =(List<Question>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2;
			
		}
	}
}
