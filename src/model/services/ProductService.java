package model.services;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entities.Product;

public class ProductService {
	
	private Predicate<Product> criteria;
	
	public Predicate<Product> getCriteria() {
		return criteria;
	}
	public void setCriteria(Predicate<Product> criteria) {
		this.criteria = criteria;
	}
	
	public double filteredSum(List<Product> list, Predicate<Product> criteria) {
		double sum = 0.0;
		for(Product p : list) {
			if(criteria.test(p)) {
				sum += p.getPrice();
			}
		}
		setCriteria(criteria);
		return sum;
	}
	public double filteredSum(List<Product> list) {
		double sum = 0.0;
		sum = filteredSum(list, criteria);
		return sum;
	}
	public List<Product> filterList(List<Product> list) {
		return list.stream().filter(criteria).collect(Collectors.toList());
	}
}
