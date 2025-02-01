package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Client client = new Client("maria", "@gmail", sdf.parse("20/10/1995"));
		Product product = new Product("hhhh", 90.00);
		OrderItem order = new OrderItem(2, 20.00, product);
		
		System.out.println(client);
		System.out.println(order);
		
		
	}
}
