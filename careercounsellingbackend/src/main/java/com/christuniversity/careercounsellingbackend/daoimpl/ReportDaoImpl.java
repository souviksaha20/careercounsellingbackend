package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.ReportDao;
import com.christuniversity.careercounsellingbackend.model.Report;

@Repository("reportDao")
@EnableTransactionManagement
public class ReportDaoImpl implements ReportDao
{
	@Autowired
	private SessionFactory sessionFactory;
	public ReportDaoImpl(SessionFactory sessionFactory) 
	{
		
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(Report r)
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(r); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional 
	public Report getReports(String id)
	{
		 String hql = "from Report where rep_id='" +id+ "'";
			Query q = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Report> list2 =(List<Report>)q.list();
			if (list2 == null || list2.isEmpty()) {
				return null;
			} 
			else 
			{	    
				return list2.get(0);
				
			} 
	}
    @Transactional 
    public boolean delete(Report r)
    {
    	try {
			sessionFactory.getCurrentSession().delete(r); 
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}  
    }
	@Transactional 
    public List<Report> reports()
    {
		 @SuppressWarnings("unchecked")
			List<Report> reportss = (List<Report>)sessionFactory.openSession().createCriteria(Report.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return reportss;
    }
}
