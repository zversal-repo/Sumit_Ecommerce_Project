package org.sumit.ECom.Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class User {

	protected String userId;
	protected String password;
	protected String name;
	protected String contact;
	protected String address;
	protected String role;
	protected String token;
	protected ArrayList<Link> links = new ArrayList<>();
	protected ArrayList<String> options;

	public User() {

	}

	protected User(User user) {
		this.userId = user.getUserId();
		this.password = user.getPassword();
		this.name = user.getName();
		this.contact = user.getContact();
		this.address = user.getAddress();
		this.role = user.getRole();
		this.options = new ArrayList<>();
		this.token = this.generatetoken();
		Link link = new Link();
		link.setLink("Profile");
		link.setRel("profile");
		this.links.add(link);

		UserDatabase.addUser(this.userId, this);
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setRole(String role) {
		this.role = role.toLowerCase();
	}

	/*
	 * void setAllInfo(String password, String name, String contact, String address)
	 * { this.password = password; this.name = name; this.contact = contact;
	 * this.address = address; }
	 */

	// Getters
	public String getUserId() {
		return this.userId;
	}

	@XmlTransient
	public String getPassword() {
		return this.password;
	}

	public String getName() {
		return this.name;
	}

	public String getContact() {
		return this.contact;
	}

	public String getAddress() {
		return this.address;
	}

	public String getRole() {
		return this.role;
	}

	@XmlTransient
	public String getToken() {
		return this.token;
	}

	public ArrayList<Link> getLinks() {
		return links;
	}

	public String generatetoken() {
		try {

			Random r = new Random();
			String input = this.userId + this.password + String.valueOf(r.nextInt(999999));
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			this.token = hashtext;
			return hashtext;

		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public int showOptions() {
		return 0;
	}

	public boolean processOptions(String string) {
		return true;
	}

}
