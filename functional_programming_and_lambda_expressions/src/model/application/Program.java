package model.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		String path = "C:\\Temp\\in.txt";
		List<Product> products = new ArrayList<Product>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				products.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();

			}
			double avg = products.stream()
					.map(x -> x.getPrice())
					.reduce(0.0, (x, y) -> x + y) / products.size();

			System.out.println("Average price: " + String.format("%.2f", avg));

			List<String> names = products.stream()
					.filter(p -> p.getPrice() < avg)
					.map(p -> p.getName())
					.sorted((p1, p2) -> p1.toUpperCase().compareTo(p2.toUpperCase()))
					.collect(Collectors.toList());

			names.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
