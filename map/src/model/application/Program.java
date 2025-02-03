package model.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, Double> c = new HashMap<String, Double>();
			String line = br.readLine();
			while (line != null) {
				String [] fields = line.split(",");
				c.put(fields[0], Double.parseDouble(fields[1]));
				line = br.readLine();
				
			}
			for(String key : c.keySet()) {
				System.out.println(key + ", " + c.get(key));
			}
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
