package com.order.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.order.DAOI.ItemServiceDAOI;
import com.order.entities.Items;

public class ItemService implements ItemServiceDAOI {

	@Override
	public boolean insertItem(Items item1) {
		boolean result = true;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrderModule");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(item1);
			entityManager.getTransaction().commit();
		} catch(PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return result;
	}

	@Override
	public List<Items> getAllItems() {
		List<Items> itemList = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrderModule");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery("queryItemsAll");
		itemList = query.getResultList();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return itemList;
	}

}
