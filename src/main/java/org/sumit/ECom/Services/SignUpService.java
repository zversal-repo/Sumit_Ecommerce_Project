package org.sumit.ECom.Services;

import org.sumit.ECom.Model.Buyer;
import org.sumit.ECom.Model.Seller;
import org.sumit.ECom.Model.User;
import org.sumit.ECom.Model.UserDatabase;

public class SignUpService {

	public boolean signUp(User user) {

		boolean b = UserDatabase.getAllUsers().containsKey(user.getUserId());

		if (!b && user.getRole().equalsIgnoreCase("buyer")) {
			new Buyer(user);
			return true;
		} else if (!b && user.getRole().equalsIgnoreCase("seller")) {
			new Seller(user);
			return true;
		} else
			return false;

	}
}
