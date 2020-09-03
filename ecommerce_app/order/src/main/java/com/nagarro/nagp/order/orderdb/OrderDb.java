package com.nagarro.nagp.order.orderdb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.order.entities.Order;
import com.nagarro.nagp.order.entities.OrderedProduct;
import com.nagarro.nagp.order.enums.OrderStatus;

@Component
public class OrderDb {

	List<OrderedProduct> orderedProducts = new ArrayList<OrderedProduct>();
//	{
//		{
//			add(new OrderedProduct("1", "3", 20));
//			add(new OrderedProduct("2", "4", 2));
//		}
//	};

	private List<Order> orders = new ArrayList<Order>() ;
//	{
//		{
//			add(new Order("1", "2", OrderStatus.SHIPPING, LocalDate.of(2020, 02, 07), orderedProducts));
//			add(new Order("2", "3", OrderStatus.DELIVERED, LocalDate.of(2020, 01, 07), orderedProducts));
//		}
//	};

	public void addOrder(Order order) {
		this.orders.add(order);
		
		
	}

	public List<Order> getOrders() {
		return this.orders;
	}
	
	public void deleteOrder(Order order) {
		 this.orders.remove(order);
	}

}
