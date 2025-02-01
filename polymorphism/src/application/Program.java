package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberOfProducts = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < numberOfProducts; i++) {
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char chr = sc.next().charAt(0);
			System.out.println("Product #" +(i+1)+ " data:");
			System.out.print("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			sc.nextLine();
			
			if(chr == 'c') {
				products.add(new Product(productName, productPrice));
				
			}else if(chr == 'i') {
				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				products.add(new ImportedProduct(productName, productPrice, customFee));
			}else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate= sdf.parse(sc.nextLine());
				products.add(new UsedProduct(productName, productPrice, manufactureDate));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product product : products) {
			System.out.println(product.priceTag());
		}
		
		
		
		sc.close();
	}

}
