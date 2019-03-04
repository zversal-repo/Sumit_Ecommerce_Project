package org.sumit.ECom.Model;

import java.util.HashMap;

public class UserDatabase {

	private static HashMap<String, User> users = new HashMap<>();

	public static HashMap<String, User> getAllUsers() {
		return users;
	}

	public static void addUser(String userId, User user) {
		users.put(userId, user);
	}

}
