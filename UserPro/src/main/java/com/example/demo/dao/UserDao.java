package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.User;

@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public User getUserByUsernameAndPassword(String username,String password){
		
			Session session = null;
			 try{
				 
				 
				session = sessionFactory.openSession();
				
				Query query = session.createQuery("from User where username = :param1 and password= :param2");
				query.setParameter("param1", username);
				query.setParameter("param2", password);
			  
				User user = (User) query.getSingleResult();
				
				return user;
				
			  }catch(Exception e){ 
				  return null; 
			  }finally { 
				  session.close();
			  }
		 
		
		
		
	}


	public List<User> findAll() {
		Session session = null;
		 try{
			 
			 
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from User");
			
		  
			return query.getResultList();
			
			
			
		  }catch(Exception e){ 
			  return null; 
		  }finally { 
			  session.close();
		  }
	}


	public void save(User user) {
		Session session = null;
		 try{
			 
			 
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.save(user);
			
		  
			session.getTransaction().commit();
			
		  }catch(Exception e){ 
			  session.getTransaction().rollback();
		  }finally { 
			  session.close();
		  }
		
	}
	
	
	
	public void update(User user) {
		Session session = null;
		 try{
			 
			 
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.update(user);
			
		  
			session.getTransaction().commit();
			
		  }catch(Exception e){ 
			  session.getTransaction().rollback();
		  }finally { 
			  session.close();
		  }
		
	}

}
