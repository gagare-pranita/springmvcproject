package com.jspider.springmvcproject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.jspider.springmvcproject.pojo.CarPOJO;

@Repository
public class CarRepository {
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
	public CarPOJO addCarDetails( String name, String brand, String fuielType, long price) {
		openConnection();
		entityTransaction.begin();
		CarPOJO pojo = new CarPOJO();
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setFuielType(fuielType);
		pojo.setPrice(price);
		
		
		entityManager.persist(pojo);
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}
	public List<CarPOJO> findAllCars() {
	
		openConnection();
		entityTransaction.begin();
		String jpql = "from CarPOJO";
		query = entityManager.createQuery(jpql);
		List<CarPOJO> cars = query.getResultList();
		entityTransaction.commit();
		closeConnection();
		return cars;
	}
	public CarPOJO removeCarDetails(int id) {
		openConnection();
		entityTransaction.begin();
	CarPOJO pojo=entityManager.find(CarPOJO.class, id);
	if(pojo!=null)
	{
		entityManager.remove(pojo);
	}
	entityTransaction.commit();
	closeConnection();
		return pojo;
	}
	public CarPOJO updateCarDetails(int id, String name, String brand, String fuielType, long price) {
		openConnection();
		entityTransaction.begin();
	CarPOJO pojo=entityManager.find(CarPOJO.class, id);
		
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setFuielType(fuielType);
		pojo.setPrice(price);
		entityManager.persist(pojo);
		entityTransaction.commit();
		closeConnection();
		
		return pojo;
	}
	public CarPOJO searchCarDetails(int id) {
		openConnection();
		entityTransaction.begin();
		CarPOJO pojo = entityManager.find(CarPOJO.class, id);
		entityTransaction.commit();
		closeConnection();
		return pojo;
	}


}
