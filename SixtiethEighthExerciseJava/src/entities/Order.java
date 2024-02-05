package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status) {
		setMoment(moment);
		setStatus(status);
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
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		
		for(OrderItem c : items) {
			sum += c.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMARY: \n");
		sb.append("Order moment: " + sdf.format(getMoment()) + "\n");
		sb.append("Order Stats: " + getStatus() + "\n");
		sb.append("Order Items: \n");
		for(OrderItem c : items) {
			sb.append(c + "\n");
		}
		
		sb.append("Total price: R$" + String.format("%.2f", total()));
		
		return sb.toString();
	}
	
}
