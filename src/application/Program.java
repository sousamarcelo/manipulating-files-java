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

import mode.entitie.Product;

public class Program {

	
	public static void main(String[] args) {	
		Locale.setDefault(Locale.US);
		String path = "C:\\temp\\file.csv";
		List<Product> products = new ArrayList<Product>();
		
		String strPath = new File(path).getParent();
		
		boolean newFolder = new File(strPath + "\\products").mkdir();
		System.out.println("folder created: " + newFolder);
		System.out.println();
		
		File folderOutPutProducts = new File(strPath + "\\products\\ListProducts.csv");
		
		
		
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while (line != null) {
				String[] vect = line.split(",");	
				products.add(new Product(vect[0], Double.parseDouble(vect[1]), Integer.parseInt(vect[2])));
				line = br.readLine();
			}
			
			/*
			//for each provisario, conferindo se objetos foram criados na lista, copiados do arquivo.
			for(Product product : products){
				System.out.println(product.getName() + "," + product.getPrice() + "," + product.getQuantity());
			}
			*/
			
			System.out.println();
			
			//copiando arquivo na pasta criada
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(folderOutPutProducts))) {
				for(Product p : products) {
					bw.write(p.toString());
					bw.newLine();
				}	
				
				System.out.println(folderOutPutProducts + "    CREATED!");
				
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
