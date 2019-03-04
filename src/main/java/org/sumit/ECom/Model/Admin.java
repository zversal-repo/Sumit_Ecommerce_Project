package org.sumit.ECom.Model;

import java.util.Scanner;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Admin extends User {

	private static int no_of_admins = 0;

	public Admin(User user) {
		super(user);
		no_of_admins++;
	}

	public void addAdmin(String userId, String password) {
		/*
		 * Authentication.addUser(new Admin(userId, password));
		 */
	}

	public boolean removeUser(String userId) {
		/*
		 * User user = Authentication.getUser(userId); if (user != null) return
		 * Authentication.deleteUser(user);
		 */
		return false;
	}

	@Override
	public int showOptions() {
		System.out.println("Enter 0 for Logout \n " + "1 for Add admin \n " + "2 for Change Info \n "
				+ "3 for Delete Account \n" + "4 for Remove User");

		return 4;
	}

	@Override
	public boolean processOptions(String string) {

		Scanner in = new Scanner(System.in);

		switch (string) {
		case "1": {
			System.out.println("Enter New AdminId \n");
			String userId = in.nextLine();
			System.out.println("Enter Password");
			String password = in.nextLine();
			addAdmin(userId, password);
			break;
		}

		case "2": {
			/*
			 * System.out.println("Enter New Password \n"); changeInfo(in.nextLine());
			 */
			break;
		}

		case "3": {

			if (no_of_admins <= 1) {
				/*
				 * System.out.println("You are the single Admin you cannot delete the account "
				 * ); } else { if (deleteAccount()) {
				 * System.out.println("Account Deleted Successfully"); return true; } else {
				 * System.out.println("Error occurs"); }
				 */

			}

			break;
		}

		case "4": {
			System.out.println("Enter UserId \n");
			String userId = in.nextLine();
			if (userId.equals(this.getUserId())) {
				/*
				 * if (no_of_admins <= 1) {
				 * System.out.println("You are the single Admin you cannot delete the account "
				 * ); } else { if (deleteAccount()) {
				 * System.out.println("Account Deleted Successfully"); return true; } else {
				 * System.out.println("Error occurs"); }
				 * 
				 * }
				 */
			} else {
				/*
				 * if (removeUser(userId)) { System.out.println("Account Deleted Successfully");
				 * } else { System.out.println("No such user exist"); }
				 */

			}
			break;
		}

		default:

			break;

		}

		in.close();

		return false;

	}

}
