package com.christuniversity.careercounsellingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.christuniversity.careercounsellingbackend.dao.DimensionDao;
import com.christuniversity.careercounsellingbackend.dao.JobDao;
import com.christuniversity.careercounsellingbackend.dao.QuestionDao;
import com.christuniversity.careercounsellingbackend.dao.ReportDao;
import com.christuniversity.careercounsellingbackend.dao.ResultDao;
import com.christuniversity.careercounsellingbackend.dao.SchoolDao;
import com.christuniversity.careercounsellingbackend.dao.StrengthDao;
import com.christuniversity.careercounsellingbackend.dao.SubjectDao;
import com.christuniversity.careercounsellingbackend.dao.UserDao;
import com.christuniversity.careercounsellingbackend.dao.User_JobsDao;
import com.christuniversity.careercounsellingbackend.dao.User_StrengthsDao;
import com.christuniversity.careercounsellingbackend.dao.User_SubjectsDao;
import com.christuniversity.careercounsellingbackend.daoimpl.DimensionDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.JobDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.QuestionDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.ReportDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.ResultDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.SchoolDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.StrengthDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.SubjectDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.UserDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.User_JobsDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.User_StrengthsDaoImpl;
import com.christuniversity.careercounsellingbackend.daoimpl.User_SubjectsDaoImpl;
import com.christuniversity.careercounsellingbackend.model.Authentication;
import com.christuniversity.careercounsellingbackend.model.Dimension;
import com.christuniversity.careercounsellingbackend.model.Job;
import com.christuniversity.careercounsellingbackend.model.Question;
import com.christuniversity.careercounsellingbackend.model.Report;
import com.christuniversity.careercounsellingbackend.model.Result;
import com.christuniversity.careercounsellingbackend.model.School;
import com.christuniversity.careercounsellingbackend.model.Strength;
import com.christuniversity.careercounsellingbackend.model.Subject;
import com.christuniversity.careercounsellingbackend.model.User;
import com.christuniversity.careercounsellingbackend.model.User_Jobs;
import com.christuniversity.careercounsellingbackend.model.User_Strengths;
import com.christuniversity.careercounsellingbackend.model.User_Subjects;





@Configuration
@ComponentScan("com.christuniversity.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("con");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/careercounsellingreal");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		System.out.println("prop");
		properties.put("hibernate.connection.pool_size", "20");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "false");
		properties.put("current_session_context_class", "thread");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		System.out.println("session");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Dimension.class);
		sessionBuilder.addAnnotatedClass(Question.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Result.class);
		sessionBuilder.addAnnotatedClass(Report.class);
		sessionBuilder.addAnnotatedClass(Strength.class);
		sessionBuilder.addAnnotatedClass(Subject.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(User_Jobs.class);
		sessionBuilder.addAnnotatedClass(User_Strengths.class);
		sessionBuilder.addAnnotatedClass(User_Subjects.class);
		sessionBuilder.addAnnotatedClass(School.class);
//		sessionBuilder.addAnnotatedClass(User.class);
//		sessionBuilder.addAnnotatedClass(City.class);
//		sessionBuilder.addAnnotatedClass(Car.class);
//		sessionBuilder.addAnnotatedClass(Catagory.class);
//		sessionBuilder.addAnnotatedClass(Brands.class);
//		sessionBuilder.addAnnotatedClass(Price.class);
//		sessionBuilder.addAnnotatedClass(RegisterCar.class);
//		sessionBuilder.addAnnotatedClass(RentCar.class);
//		sessionBuilder.addAnnotatedClass(Authentication.class);
		// sessionBuilder.buildMapping(net.viralpatel.hibernate.UserDetails2);
		return sessionBuilder.buildSessionFactory();
   }

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("prop");
		return transactionManager;
	}

	@Autowired
	@Bean(name = "dimensionDao")
	public DimensionDao  getDimensionDao(SessionFactory sessionFactory) {
		return new DimensionDaoImpl(sessionFactory);
	}
	
	
	 @Autowired
	 @Bean(name = "questionDao")
	 public QuestionDao getQuestionDao(SessionFactory sessionFactory) {
	 return new QuestionDaoImpl(sessionFactory);
	 }
	 @Autowired
		@Bean(name = "userDao")
		public UserDao UserDaoget(SessionFactory sessionFactory) {
			return new UserDaoImpl(sessionFactory);
		}
	 
	 @Autowired
	 @Bean(name = "resultDao")
	 public ResultDao getResultDao(SessionFactory sessionFactory) {
	 return new ResultDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "reportDao")
	 public ReportDao getReportDao(SessionFactory sessionFactory) {
	 return new ReportDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "strengthDao")
	 public StrengthDao getStrengthDao(SessionFactory sessionFactory) {
	 return new StrengthDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "subjectDao")
	 public SubjectDao getSubjectDao(SessionFactory sessionFactory) {
	 return new SubjectDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "jobDao")
	 public JobDao getJobDao(SessionFactory sessionFactory) {
	 return new JobDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "user_StrengthsDao")
	 public User_StrengthsDao getUser_StrengthsDao(SessionFactory sessionFactory) {
	 return new User_StrengthsDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "user_SubjectsDao")
	 public User_SubjectsDao getUser_SubjectsDao(SessionFactory sessionFactory) {
	 return new User_SubjectsDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "user_JobsDao")
	 public User_JobsDao getUser_JobsDao(SessionFactory sessionFactory) {
	 return new User_JobsDaoImpl(sessionFactory);
	 }
	 @Autowired
	 @Bean(name = "schoolDao")
	 public SchoolDao getSchool(SessionFactory sessionFactory) {
	 return new SchoolDaoImpl(sessionFactory);
	 }
}
