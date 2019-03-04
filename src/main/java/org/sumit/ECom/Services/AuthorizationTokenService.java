package org.sumit.ECom.Services;

import java.util.HashMap;

import org.sumit.ECom.Model.User;
import org.sumit.ECom.Model.UserDatabase;

public class AuthorizationTokenService {

	public String getAuthorizationToken(String userId, String password) {

		HashMap<String, User> users = UserDatabase.getAllUsers();

		if (users.containsKey(userId) && users.get(userId).getPassword().equals(password)) {
			return users.get(userId).generatetoken();
		}
		return null;
	}

}
