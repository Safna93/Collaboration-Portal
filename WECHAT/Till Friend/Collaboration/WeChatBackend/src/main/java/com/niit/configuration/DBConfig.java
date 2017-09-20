package com.niit.configuration;


	import java.util.Properties;



	import javax.sql.DataSource;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.hibernate4.HibernateTransactionManager;
	import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
	import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;
import com.niit.model.Chat;
import com.niit.model.Friend;
import com.niit.model.Job;

import com.niit.model.ProfilePicture;
import com.niit.model.User;

	@Configuration
	@ComponentScan("com.niit")
	@EnableTransactionManagement
	public class DBConfig 
	{
	@Bean(name="dataSource")
	public DataSource getH2Datasource()
	{
		System.out.println("Starting of the method getH2datasource");
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/test2");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("Data source Creation");
		return dataSource;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		System.out.println("Hibernate properties");
		Properties prop=new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto","update");
		prop.put("hibernate.show_sql","true");//optional
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("Hibernate properties created");
		
		System.out.println("Local session factory object creation");
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(getH2Datasource());
		sessionBuilder.addProperties(prop);
		System.out.println("Factory builder object created");
		
		
		sessionBuilder.addAnnotatedClass(User.class).addAnnotatedClass(Job.class).addAnnotatedClass(BlogPost.class).addAnnotatedClass(BlogComment.class).addAnnotatedClass(ProfilePicture.class).addAnnotatedClass(Friend.class).addAnnotatedClass(Chat.class);
		
		System.out.println("Session factory object creation");
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		System.out.println("Session factory object created");
		return sessionFactory;
	}

	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction manager object creation");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction manager object created");
		return transactionManager;
	}
	}

