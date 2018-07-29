package com.christuniversity.careercounsellingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.ResultDao;
import com.christuniversity.careercounsellingbackend.model.Report;
import com.christuniversity.careercounsellingbackend.model.Result;
import com.christuniversity.careercounsellingbackend.model.User_Subjects;

@Repository("resultDao")
@EnableTransactionManagement
public class ResultDaoImpl implements ResultDao
{
	@Autowired
	private SessionFactory sessionFactory;
	public ResultDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public boolean saveorupdate(Result r) {
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
	public Result getResults(String id) {
		String hql = "from Result where res_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Result> list2 =(List<Result>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
			
		} 
	}

	@Transactional
	public boolean delete(Result r) {
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
	public List<Result> results()
    {
		 @SuppressWarnings("unchecked")
			List<Result> resultss = (List<Result>)sessionFactory.openSession().createCriteria(Result.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return resultss;
    }
	@Transactional
	public Result getResultByQuestion(String id)
	{
		String hql = "from Result where question_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Result> list2 =(List<Result>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
		}
	}
	@Transactional
	public Result getResultByQnU(String x,String y)
	{
		String hql = "from Result where question_id='" +x+ "'and report_id='"+y+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Result> list2 =(List<Result>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2.get(0);
		}
	}
	@Transactional
	public List<Result> resByDim(String id)
	{	
//		System.out.println("ResultDaoImpl here");
		String zx="select e from Employee e inner join e.team";
		String hql = "from Result r inner join r.question where dimension_id='" +id+ "' and answer='"+1+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Result> list2 =(List<Result>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2;
		}
	}
	
	@Transactional
	public List<Result> resByRep(String id)
	{	
//		System.out.println("ResultDaoImpl here");
		String hql = "from Result where report_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Result> list2 =(List<Result>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2;
		}
	}
//	public Result getResultByReport(String id)
//	{	
//		String hql = "from Result where report_id='"+id+"'";
//		Query q = sessionFactory.getCurrentSession().createQuery(hql);
//		@SuppressWarnings("unchecked")
//		List<Result> list2 =(List<Result>)q.list();
//		if (list2 == null || list2.isEmpty()) {
//			return null;
//		} 
//		else 
//		{	    
//			return list2.get(0);
//		}
//	}
	@Transactional
	public List<Result> resByDimnRep(String dimid,String repid)
	{	
//		System.out.println("New method with user in report daoimpl");
//		String abc="FROM Result INNER JOIN Question ON Question.dimension_id = '"+dimid+"' AND Result.answer='"+1+"' AND Result.report_id='"+repid+"'";
//		String zx="select e from Employee e inner join e.team";
//		String zx1="FROM Result r, Question q WHERE r.question_id = q.que_id AND q.dimension_id ='" +dimid+"' AND r.answer='"+1+"' AND r.report_id='"+repid+"'";
//		String zx2="FROM Result r INNER JOIN r.question q where r.answer='"+1+"' and dimension_id='"+dimid+"' and r.report_id='"+repid+"'";
		String hql = "from Result r inner join r.question where dimension_id='" +dimid+ "' and answer='"+1+"' and report_id='"+repid+"'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Result> list2 =(List<Result>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2;
		}
	}
	@Transactional
	public List<Result> resByQue(String id)
	{	
//		System.out.println("ResultDaoImpl here");
		String hql = "from Result where question_id='" +id+ "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Result> list2 =(List<Result>)q.list();
		if (list2 == null || list2.isEmpty()) {
			return null;
		} 
		else 
		{	    
			return list2;
		}
	}
	
}
