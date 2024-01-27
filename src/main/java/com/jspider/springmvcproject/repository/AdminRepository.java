package com.jspider.springmvcproject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.springmvcproject.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static  EntityTransaction entityTransaction;
	private static Query query;
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("cardetails");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();	
	
	}
	private static void closeConnection() {
		if(entityManagerFactory!=null)
		{
			entityManagerFactory.close();
		}
		if(entityManager!=null)
		{
			entityManager.close();
		}
		if(entityTransaction!=null)
		{
			if(entityTransaction.isActive())
			{
				entityTransaction.rollback();
			}
		}
	}

	public AdminPOJO getAdmin() {
		openConnection();
		entityTransaction.begin();
		String jpql="from AdminPOJO";
		query=entityManager.createQuery(jpql);
		List<AdminPOJO > admins=query.getResultList();
		if(admins.isEmpty()==false)
		{
			for(AdminPOJO pojo:admins)
			{
				entityTransaction.commit();
				closeConnection();
				return pojo;
			}
		}
		entityTransaction.commit();
		closeConnection();
	
		return null;
	}
	public AdminPOJO createAccount(String username, String password) {
openConnection();
entityTransaction.begin();

AdminPOJO pojo=new AdminPOJO ();
pojo.setUsername(username);
pojo.setPassword(password);
entityManager.persist(pojo);
entityTransaction.commit();
closeConnection();
		return pojo;
	}
	public AdminPOJO login(String username, String password) {
	openConnection();
	entityTransaction.begin();
	String jpql="from AdminPOJO"
			            + "where username = '" + username + "' "
			            + "and password = '" + password + "'";
	
	query=entityManager.createQuery(jpql);
	List<AdminPOJO> admins=query.getResultList();
	if(admins.isEmpty()==false)
	{
		for(AdminPOJO  pojo:admins)
		{
			entityTransaction.commit();
			closeConnection();
			System.out.println(pojo);
			return pojo;
		}
	}
			entityTransaction.commit();
	closeConnection();
		return null;
	}

}
