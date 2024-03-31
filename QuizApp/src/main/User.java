package main;

import java.util.Map;
import java.util.Scanner;

public class User {
	private int id;
	private String name;
	private String password;
	private String role;
	
	Map<String, User> mapUser;

	public User(Map<String, User> mapUser, int userId) {
		this.mapUser = mapUser;
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the mapUser
	 */
	public Map<String, User> getMapUser() {
		return mapUser;
	}

	/**
	 * @param mapUser the mapUser to set
	 */
	public void setMapUser(Map<String, User> mapUser) {
		this.mapUser = mapUser;
	}
	
	public void askLoginInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your username: ");
		this.name = scanner.nextLine();
		
		System.out.println("Enter your password: ");
		this.password = scanner.nextLine();
		
		
	}

	public void askRegisterInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your username: ");
		this.name = scanner.nextLine().toLowerCase();
		
		// Check if the username already exists
		if (mapUser.containsKey(this.name)) {
			System.out.println("Username already exists. Please choose a different username.");
			askRegisterInput();
		} else {
			System.out.println("Enter you password: ");
			this.password = scanner.nextLine();
			
			System.out.println("Enter your role: ");
			this.role = scanner.nextLine();
			
			mapUser.put(name, this);
		
		}	
	}
}
