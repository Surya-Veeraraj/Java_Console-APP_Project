package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Map<String, User> mapUser = new HashMap<>();
		int UserId = 0;
		
		Scanner scanner = new Scanner(System.in);
		int ch;
		do {
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("Enter your choice");
		ch = scanner.nextInt();
		
			switch (ch) {
			case 1:
				User loginUser = new User(mapUser, UserId);
				loginUser.askLoginInput();
				break;
			case 2:	
				UserId++;
				User registerUser = new User(mapUser, UserId);
				registerUser.askRegisterInput();
				break;
			case 3:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (ch != 3);
		
		scanner.close();

	}

}
