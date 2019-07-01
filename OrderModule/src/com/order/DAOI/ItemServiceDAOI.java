package com.order.DAOI;

import java.util.List;

import com.order.entities.Items;

public interface ItemServiceDAOI {

	boolean insertItem(Items item1);

	List<Items> getAllItems();
	
}
