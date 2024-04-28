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
		this.id = userId;

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

	public boolean authenticate(String enteredPassword) {
		return password.equals(enteredPassword);
	}

	public void askLoginInput(Scanner scanner) {
		boolean isValidLogin = false;
		int attempts = 0;
		final int MAX_ATTEMPTS = 3;

		do {
			System.out.println("Enter your username: ");
			String usernameInput = scanner.nextLine().toLowerCase();

			if (!mapUser.containsKey(usernameInput)) {
				System.out.println("Username does not exist. Please try again.");
				continue; // Repeat the loop to ask for userName again
			}
			User user = mapUser.get(usernameInput);

			System.out.println("Enter your password: ");
			String passwordInput = scanner.nextLine();

			if (!passwordInput.equals(user.getPassword())) {
				System.out.println("Incorrect password.Please try again.");
				attempts++;
			} else {
				isValidLogin = true;
				this.name = usernameInput;
				this.password = passwordInput;
				this.role = user.getRole();
			}
			if (attempts >= MAX_ATTEMPTS) {
				System.out.println("Maximum login attempts exceeded.");
				return;
			}
		} while (!isValidLogin);
	}
//				System.out.println("1. Try again");
//				System.out.println("Exit");
//				int choice = scanner.nextInt();
//				if (choice == 1) {
//					askLoginInput();
//				} else if (choice == 1) {
//					System.out.println("Exiting...");
//					System.exit(0);
//				} else {
//					System.out.println("Invalid choice Exiting...");
//					System.exit(0);
//				}
//
//				askLoginInput();
//			}
//		} while (!isValidLogin);
//	}

	public void askRegisterInput(Scanner scanner) {
		System.out.println("Enter your username: ");
		this.name = scanner.nextLine().toLowerCase();

		// Check if the userName already exists
		if (mapUser.containsKey(this.name)) {
			System.out.println("Username already exists. Please choose a different username.");
			return;
		}
		System.out.println("Enter you password: ");
		this.password = scanner.nextLine();

		if (this.name.isEmpty() || this.password.isEmpty()) {
			System.out.println("Username or password cannot be empty.");
			return;
		}

		System.out.println("Enter your role: ");
		this.role = scanner.nextLine();

		mapUser.put(name, this);

	}

}
