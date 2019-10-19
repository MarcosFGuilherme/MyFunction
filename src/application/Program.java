package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import model.services.ProductService;

public class Program {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		showProduct(list);
		
		ProductService ps = new ProductService();
		double sum =  ps.filteredSum(list);
		
		
		System.out.println("Sum products only letter initial = [T]");
		showProduct(ps.filterList(list));
		System.out.println("Total sum : " + String.format("%.2f", sum));
		
		
	}
	public static void showProduct(List<Product> list) {
		list.sort((p1,p2)-> p1.getPrice().compareTo(p2.getPrice()));
		for (Product p : list) {
			System.out.println(p);
		}
		System.out.println();
	}
}
