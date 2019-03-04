package org.sumit.ECom.Services;

import org.sumit.ECom.Model.Product;
import org.sumit.ECom.Model.Products;

public class SellerOptions {

	public boolean addProduct(String sellerId, Product product) {
		return Products.addProduct(sellerId, product);
	}

}
