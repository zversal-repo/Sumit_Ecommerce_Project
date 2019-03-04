package org.sumit.ECom.Services;

import java.util.HashMap;

import org.sumit.ECom.Model.Admin;
import org.sumit.ECom.Model.Buyer;
import org.sumit.ECom.Model.Seller;
import org.sumit.ECom.Model.User;
import org.sumit.ECom.Model.UserDatabase;

public class ProfileService {

	public User getProfile(String token) {

		HashMap<String, User> users = UserDatabase.getAllUsers();

		for (User user : users.values()) {
			if (user.getToken().equals(token)) {
				if (user.getRole().equalsIgnoreCase("buyer")) {
					return (Buyer) user;
				} else if (user.getRole().equalsIgnoreCase("seller")) {
					return (Seller) user;
				} else if (user.getRole().equalsIgnoreCase("admin")) {
					return (Admin) user;
				}
			}

		}

		return null;

	}

}
