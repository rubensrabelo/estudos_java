package ex_02_product.application;

import java.util.Locale;
import java.util.Scanner;

import ex_02_product.entities.Product;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter product data:");
		
		System.out.println("Name: ");
		String name = sc.nextLine();
		
		System.out.println("Price: ");
		double price = sc.nextDouble();
		
		System.out.println("Quantity in stock: ");
		int quantity = sc.nextInt();
		
		Product product = new Product(name, price, quantity);
		
		System.out.println(product);
		System.out.println();
		
		System.out.println("Enter the number of products to be added in stock: ");
		quantity = sc.nextInt();
		
		product.addProducts(quantity);
		
		System.out.println(product);
		System.out.println();
		
		System.out.println("Enter the number of products to be removed in stock: ");
		quantity = sc.nextInt();
		
		product.removeProducts(quantity);
		
		System.out.println(product);
		
		sc.close();
	}
	
}
