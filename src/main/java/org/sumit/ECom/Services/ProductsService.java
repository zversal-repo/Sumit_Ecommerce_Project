package org.sumit.ECom.Services;

import java.util.ArrayList;

import org.sumit.ECom.Model.Product;
import org.sumit.ECom.Model.Products;

public class ProductsService {

	public ArrayList<Product> getProducts(String sellerId, String productId, String productName) {

		if (sellerId == null && productId == null && productName == null) {
			ArrayList<Product> productList = new ArrayList<>();
			for (String seller : Products.getProducts().keySet()) {
				productList.addAll(Products.getProducts().get(seller));
			}
			return productList;
		} else if (productId == null && productName == null) {
			return Products.getProductBySellerId(sellerId);
		} else if (productName == null && sellerId == null) {
			return Products.getProductByProductId(productId);
		} else if (productId == null && sellerId == null) {
			return Products.getProductByProductName(productName);

		}

		return null;

	}

}
