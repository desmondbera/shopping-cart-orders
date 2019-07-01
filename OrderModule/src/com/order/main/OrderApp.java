package com.order.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//import javax.mail.FetchProfile.Item;

import com.order.entities.Items;
import com.order.entities.Orders;
import com.order.services.ItemService;
import com.order.services.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		System.out.println("Initializing order app!");
//		System.out.println("Our cart is: ");
//		showAllItems();
		
		// Users will choose between ITEMS menu and ORDERS menu
		// Under the ITEMS menu, user will have the following options:
		// 1. New Item
//			Items item1 = new Items(3, "Shorts", "Breathable mesh shorts.", 10, 12.99, 200);
//			insertNewItem(item1);
		// 2. Update Item
		// 3. Remove Item
		// 4. Show Items by TITLE
		// 5. Show Items by CATEGORY
		// 6. Show Items by ID
		
	
		//User will have to choose one of the options:
		System.out.println("Welcome to the Orders Menu. Please choose one of the options below: ");
		System.out.println("1. Place a new order.");
		System.out.println("2. Confirm order.");
		System.out.println("3. Cancel order.");
		System.out.println("4. Delete order.");
		System.out.println("5. Show all confirmed orders.");
		System.out.println("6. Show all open orders.");
		System.out.println("7. Show all cancelled orders.");
		//1. Place a new order
		//1.1 When user wants to input a new order, we have 3 options
			// We need to pass it an object of Item (could be named anything).
			//A. Add Items
//			addItemToCart();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		choice = sc.nextInt();
		switch(choice) {
			case 1:
				int choice2 = 0;
				System.out.println("Pick one of the following: ");
				System.out.println("1. Add items");
				System.out.println("2. Remove Items");
				System.out.println("3. Update Items Quantity");
				choice2 = sc.nextInt();
				switch(choice2) {
					case 1: 
						System.out.println("Enter item id: ");
						int itemId = sc.nextInt();
						
						System.out.println("Enter order number: ");
						String itemOrdNum = sc.next();
						
						System.out.println("Enter date (YYYY-MM-DD) of order: ");
						String itemDate = sc.next();
						sc.nextLine();
						DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
						Date dateObj = sdf.parse(itemDate);
						
						System.out.println("Enter comments: ");
						String itemComments = sc.next();
						
						System.out.println("Enter order status: ");
						int itemStatus = sc.nextInt();
						
						Orders orderItem = new Orders(itemId, itemOrdNum, (java.sql.Date) dateObj, itemComments, itemStatus);
						
//						Items newItem = new Items(itemId, itemTitle, itemDescription, itemQuantity, itemPrice, itemCategoryId);
						addItemToOrder(orderItem);
						break;
					case 2:
						System.out.println("Enter id of item to remove: ");
						int itemId2 = sc.nextInt();
						Items newItem2 = new Items();
						newItem2.setId(itemId2);
						removeItemsFromCartById(newItem2);
				}				
		}
			//B. Remove Items
//			removeItemsFromCartById();
			
			//C. Update Items (quantity)		
		//2. Confirm order
		//3. Cancel Order
		//4. Delete Order
		//5. Show all CONFIRMED orders
		//6. Show all OPEN orders
		//7. SHow all CANCELED order
	}

	private static void showAllItems() {
		ItemService itemServ = new ItemService();
		List<Items> itemList = new ArrayList<>();
		itemList = itemServ.getAllItems();
		for(Items e : itemList) {
			System.out.println(e.toString());
		}
	}

	private static void insertNewItem(Items item1) {
		ItemService itemServ = new ItemService();
		boolean result = itemServ.insertItem(item1);
		if(result) {
			System.out.println("Successfully inserted new item!");
		} else {
			System.out.println("Failed to insert new item.");
		}
	}

	private static void removeItemsFromCartById(Items item) {
		OrderService orderServ = new OrderService();
		boolean result = false;
		Items findItem = orderServ.findItem(item);
		if(findItem != null) {
			result = orderServ.removeItemFromCartById(findItem);
			if(result) {
				System.out.println("Removed item: " + findItem.getId());
			} else {
				System.out.println("Item " + findItem.getId() + " was not removed.");
			}
		} else {
			System.out.println("Item " + item.getId() + " not found.");
		}
	}

	private static void addItemToOrder(Orders orderItem) {
		OrderService orderServ = new OrderService();
		boolean result = orderServ.addToOrder(orderItem);
		if(result) {
			System.out.println("Added item to db!");
		} else {
			System.out.println("Failed to add item to db!");
		}
	}

}
