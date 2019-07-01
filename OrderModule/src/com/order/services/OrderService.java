package com.order.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.order.DAOI.OrderServiceDAOI;
import com.order.entities.Items;
import com.order.entities.Orders;

public class OrderService implements OrderServiceDAOI {
	
	@Override
	//Input: item to input into cart
	//Returns: boolean; denoting if successfully added to database 
	public boolean addToOrder(Orders orderItem) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrderModule");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(orderItem);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entityManager.close();
			entityManagerFactory.close();		}
		
		return result;
	}

	@Override
	public boolean removeItemFromCartById(Items item) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrderModule");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			
		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return result;
	}

	public Items findItem(Items item) {

		Items findItem = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrderModule");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			findItem = entityManager.find(Items.class, item.getId());
		} catch(PersistenceException e) {
			e.getMessage();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return findItem;
	}



}
