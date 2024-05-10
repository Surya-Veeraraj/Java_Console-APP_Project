package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import question.QuestionManager;
import roles.AdminActions;
import roles.StudentActions;

public class MainApp {

	public static void main(String[] args) {
		Map<String, User> mapUser = new HashMap<>();
		int userId = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			QuestionManager questionManager = new QuestionManager();
			int choice;
			do {
				displayMenu();
				choice = getUserChoice(scanner);
				switch (choice) {
				case 1:
					loginUser(mapUser, userId, questionManager, scanner);
					break;
				case 2:
					registerUser(mapUser, userId, scanner);
					userId++; // Increment user ID after successful registration
					break;
				case 3:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice.");
					break;
				}
			} while (choice != 3);
		}
	}

	private static void displayMenu() {
		System.out.println("=== Main Menu ===");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.println("Enter your choice:");
	}

	private static int getUserChoice(Scanner scanner) {
		int choice;
		while (true) {
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character
				return choice;
			} else {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine(); // Consume the invalid input
			}
		}
	}

	private static void loginUser(Map<String, User> mapUser, int userId, QuestionManager questionManager,
			Scanner scanner) {
		User loginUser = new User(mapUser, userId);
		boolean loginSuccessful = loginUser.askLoginInput(scanner);

		if (!loginSuccessful) {
			return; // Exit the method if login failed
		}
		System.out.println("Successfully logged in");

		if (loginUser.getRole().equalsIgnoreCase("admin")) {
			System.out.println("Welcome to the Quiz Admin!");
			AdminActions.performAdminActions(questionManager, scanner); // Pass scanner object
		} else if (loginUser.getRole().equalsIgnoreCase("student")){ // Only allow students to play the quiz
			StudentActions student = new StudentActions(questionManager);
			student.takeQuiz(scanner);
		} else {
			System.out.println("Sorry, you are not authorized to play the quiz.");
		}
	}

	private static void registerUser(Map<String, User> mapUser, int userId, Scanner scanner) {
		User registerUser = new User(mapUser, userId);
		registerUser.askRegisterInput(scanner);
		System.out.println("Registration is successful");
	}
}
