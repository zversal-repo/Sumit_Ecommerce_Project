package org.sumit.ECom.Model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products {

	private static HashMap<String, ArrayList<Product>> products = new HashMap<>();

	static {
		HashMap<String, String> details = new HashMap<>();
		details.put("Keyword", "45");
		ArrayList<Product> product = new ArrayList<>();
		product.add(new Product("1", "1", "Hello World", "4", "5", "3", details));
		products.put("1", product);
		HashMap<String, String> details1 = new HashMap<>();
		details1.put("Keyword", "459");
		ArrayList<Product> product1 = new ArrayList<>();
		product1.add(new Product("2", "13", "Hello World", "4", "5", "3", details));
		products.put("2", product);
	}

	public static HashMap<String, ArrayList<Product>> getProducts() {
		return products;
	}

	public static boolean addProduct(String sellerId, Product product) {

		if (products.containsKey(sellerId)) {
			products.get(sellerId).add(product);
			return true;
		}

		else {
			products.put(sellerId, new ArrayList<Product>());
			products.get(sellerId).add(product);
			return true;
		}
	}

	public static ArrayList<Product> getProductBySellerId(String sellerId) {
		if (products.containsKey(sellerId)) {
			return products.get(sellerId);
		} else {
			return null;
		}
	}

	public static ArrayList<Product> getProductByProductName(String productName) {

		ArrayList<Product> productList = new ArrayList<>();

		for (String sellerId : products.keySet()) {
			for (Product product : products.get(sellerId)) {
				if (product.getProductName().contains(productName)) {
					productList.add(product);
				}
			}
		}
		if (!productList.isEmpty()) {
			return productList;
		}

		return null;
	}

	public static ArrayList<Product> getProductByProductId(String productId) {

		ArrayList<Product> productList = new ArrayList<>();

		for (String sellerId : products.keySet()) {
			for (Product product : products.get(sellerId)) {
				if (product.getProductId().equals(productId)) {
					productList.add(product);
				}
			}
		}
		if (!productList.isEmpty()) {
			return productList;
		}

		return null;
	}

	public static ArrayList<Product> getProductByProductPrice(String productPrice) {

		ArrayList<Product> productList = new ArrayList<>();

		for (String sellerId : products.keySet()) {
			for (Product product : products.get(sellerId)) {
				if (product.getFinalPrice().equals(productPrice)) {
					productList.add(product);
				}
			}
		}
		if (!productList.isEmpty()) {
			return productList;
		}

		return null;
	}

}
