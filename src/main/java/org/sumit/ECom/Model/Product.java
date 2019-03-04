package org.sumit.ECom.Model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private String productId;
	private String productName;
	private String rating;
	private String sellerId;
	private float marketPrice;
	private float discount;
	private float finalPrice;
	private int stock;
	private int no_of_ratings;
	private HashMap<String, String> details;

	public Product(String sellerId, String productId, String productName, String marketPrice, String discount,
			String stock, HashMap<String, String> details) {
		this.productId = productId;
		this.productName = productName;
		this.marketPrice = Float.parseFloat(marketPrice);
		this.discount = Float.parseFloat(discount);
		this.finalPrice = ((1 - this.discount / 100) * this.marketPrice);
		this.stock = Integer.parseInt(stock);
		this.details = details;
		this.no_of_ratings = 1;
		this.rating = "5.0";
		this.sellerId = sellerId;
	}

	// Getters

	public String getProductId() {
		return (this.productId);

	}

	public String getProductName() {
		return this.productName;
	}

	public String getRating() {
		return this.rating;
	}

	public String getSellerId() {
		return this.sellerId;
	}

	public HashMap<String, String> getDetails() {
		return (this.details);
	}

	public String getStock() {
		return String.valueOf(this.stock);
	}

	public String getMarketPrice() {
		return String.valueOf(this.marketPrice);
	}

	public String getFinalPrice() {
		return String.valueOf(this.finalPrice);
	}

	public String getDiscount() {
		return String.valueOf(this.discount);
	}

	// Setters

	void setProductId(String productId) {
		this.productId = productId;
	}

	void setProductName(String productName) {
		this.productName = productName;
	}

	void setStock(String stock) {
		this.stock = Integer.parseInt(stock);
	}

	void setMarketPrice(String marketPrice) {
		this.marketPrice = Float.parseFloat(marketPrice);
		this.finalPrice = (1 - (this.discount / 100)) * (this.marketPrice);
	}

	void setDiscount(String discount) {
		this.discount = Float.parseFloat(discount);
		this.finalPrice = (1 - (this.discount / 100)) * (this.marketPrice);
	}

	void setFinalPrice(String finalPrice) {
		this.finalPrice = Float.parseFloat(finalPrice);
		this.discount = (1 - (this.finalPrice / this.marketPrice)) * 100;
	}

	void setRating(String rating) {

		this.rating = String.valueOf((Double.parseDouble(this.rating) * this.no_of_ratings + Double.parseDouble(rating))
				/ ++this.no_of_ratings);
	}

}
