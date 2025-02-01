package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> itemsList = new ArrayList<OrderItem>();
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status) {
		super();
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void addItem(OrderItem item) {
		itemsList.add(item);
	}
	public void removeItem(OrderItem item) {
		itemsList.remove(item);
	}
}
