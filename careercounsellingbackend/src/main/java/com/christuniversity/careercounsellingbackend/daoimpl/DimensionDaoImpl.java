package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.DimensionDao;
import com.christuniversity.careercounsellingbackend.dao.QuestionDao;
import com.christuniversity.careercounsellingbackend.model.Dimension;
import com.christuniversity.careercounsellingbackend.model.Question;
import com.christuniversity.careercounsellingbackend.model.Result;


@Repository("dimensionDao")
@EnableTransactionManagement
public class DimensionDaoImpl implements DimensionDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DimensionDaoImpl(SessionFactory sessionFactory) 
	{
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(Dimension c)
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
	public Dimension getDimensions(String id)
	{
		 String hql = "from Dimension where Dime_id='" +id+ "'";
			Query q = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Dimension> list2 =(List<Dimension>)q.list();
			if (list2 == null || list2.isEmpty()) {
				return null;
			} 
			else 
			{	    
				return list2.get(0);
				
			} 
	}
    @Transactional 
    public boolean delete(Dimension c)
    {
    	try {
    		QuestionDaoImpl q=new QuestionDaoImpl(sessionFactory);
    		ResultDaoImpl r=new ResultDaoImpl(sessionFactory);
    		List<Question> questionlist = (List<Question>) q.getquesbyDim(c.getDime_id());
    		if(questionlist!=null)
    		{
    			System.out.println("There were "+questionlist.size()+" questions in "+c.getDime_name()+". Deleted");
    			for(Question q1:questionlist)
    			{
    				List<Result> resultlist = (List<Result>) r.resByQue(q1.getQue_id());
    				System.out.println("There were "+resultlist.size()+" results related to "+q1.getQue_id()+". Deleted");
    				if(resultlist!=null)
    					for(Result r1:resultlist)
    						sessionFactory.getCurrentSession().delete(r1);
    				sessionFactory.getCurrentSession().delete(q1);
    			}
    		}
			sessionFactory.getCurrentSession().delete(c); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
    }
	@Transactional 
    public List<Dimension> Dimensions()
    {
		String hql = "from Dimension order by dime_details asc ";
		  Query q = sessionFactory.getCurrentSession().createQuery(hql);
		  @SuppressWarnings("unchecked")
		  List<Dimension> list2 =(List<Dimension>)q.list();
		  if (list2 == null || list2.isEmpty()) {
		   return null;
		  } 
		  else 
		  {     
		   return list2;
		   
		  }
    }
}
