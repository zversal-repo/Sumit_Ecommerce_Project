package org.sumit.ECom.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Seller extends User {

	private int no_of_ratings;
	private String rating;

	public Seller(User user) {
		super(user);
		this.rating = "5.0";
		this.no_of_ratings = 1;
	}

	// Setters
	public void setRating(String rating) {
		this.rating = String.valueOf((Double.parseDouble(this.rating) * this.no_of_ratings + Double.parseDouble(rating))
				/ ++this.no_of_ratings);

	}

	// Getters
	public String getRating() {
		return this.rating;
	}

	// Interface for Functionalities

	@Override
	public int showOptions() {
		return 0;
	}

	@Override
	public boolean processOptions(String string) {
		return true;
	}

}
