package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args ) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Birth Date: (DD/MM/YYYY) ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status);
		
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem oi = new OrderItem(productQuantity, productPrice, product);
			order.addItem(oi);
		}
		
		System.out.println();
		System.out.println(client);
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}
	
}
