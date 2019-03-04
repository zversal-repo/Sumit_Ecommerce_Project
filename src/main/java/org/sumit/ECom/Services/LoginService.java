package org.sumit.ECom.Services;

import java.util.HashMap;

import org.sumit.ECom.Model.User;
import org.sumit.ECom.Model.UserDatabase;

public class LoginService {

	public User getUserInfo(String userId, String password) {

		HashMap<String, User> users = UserDatabase.getAllUsers();

		if (users.containsKey(userId) && users.get(userId).getPassword().equals(password))
			return users.get(userId);

		return null;

	}

}
