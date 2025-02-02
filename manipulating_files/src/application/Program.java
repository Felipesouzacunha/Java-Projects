package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import intities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		File pathRead = new File("C:\\Temp\\ws-eclipse\\manipulating_files\\in.txt");
		File pathwriter = new File("C:\\Temp\\ws-eclipse\\manipulating_files\\out.txt");

		List<Product> products = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(pathRead))) {
			String line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				products.add(new Product(vect[0], Double.parseDouble(vect[1]), Integer.parseInt(vect[2])));
				line = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathwriter))) {
				for (Product p : products) {
					bw.write(p.getName() + "," + p.totalPrice());
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
