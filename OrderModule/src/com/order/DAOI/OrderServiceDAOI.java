package com.order.DAOI;

import com.order.entities.Items;
import com.order.entities.Orders;

public interface OrderServiceDAOI {

	boolean removeItemFromCartById(Items item);
	boolean addToOrder(Orders orderItem);

}
