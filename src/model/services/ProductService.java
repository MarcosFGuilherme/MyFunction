package model.services;

import java.util.List;
import java.util.stream.Collectors;

import entities.Product;

public class ProductService {
	public double filteredSum(List<Product> list) {
		double sum = 0.0;
		for(Product p : list) {
			if(p.getName().charAt(0) == 'T') {
				sum += p.getPrice();
			}
		}
		return sum;
	}
	public List<Product> filterList(List<Product> list) {
		return list.stream().filter(p -> p.getName().charAt(0) == 'T').collect(Collectors.toList());
	}
}
