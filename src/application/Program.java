package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mode.entitie.Product;

public class Program {

	public static void main(String[] args) {	
		Locale.setDefault(Locale.US);
		String path = "C:\\temp\\file.csv";
		List<Product> products = new ArrayList<Product>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while (line != null) {
				String[] vect = line.split(",");	
				products.add(new Product(vect[0], Double.parseDouble(vect[1]), Integer.parseInt(vect[2])));
				line = br.readLine();
			}
			
			//for each provisario, conferindo se objetos foram criados na lista, copiados do arquivo.
			for(Product product : products){
				System.out.println(product.getName() + "," + product.getPrice() + "," + product.getQuantity());
			}
			
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		

	}

}
