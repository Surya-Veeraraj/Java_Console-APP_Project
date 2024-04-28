package roles;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import question.Question;
import question.QuestionManager;

public class AdminActions {

	public static void performAdminActions(QuestionManager questionManager, Scanner scanner) {
		int adminChoice;
		do {
			displayAdminMenu();
			adminChoice = getUserChoice(scanner);
			switch (adminChoice) {
			case 1:
				viewQuestions(questionManager);
				break;
			case 2:
				editQuestion(scanner, questionManager);
				break;
			case 3:
				deleteQuestion(scanner, questionManager);
				break;
			case 4:
				addQuestion(scanner, questionManager);
				break;
			case 5:
				System.out.println("Exiting Admin Panel.");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (adminChoice != 5);
	}

	private static void displayAdminMenu() {
		System.out.println("1. View All Questions and Options");
		System.out.println("2. Edit Question");
		System.out.println("3. Delete Question");
		System.out.println("4. Add Question");
		System.out.println("5. Exit Admin Panel");
		System.out.println("Enter your choice:");
	}

	private static int getUserChoice(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter a number.");
			scanner.next(); // Consume invalid input
		}
		return scanner.nextInt();
	}

	private static void viewQuestions(QuestionManager questionManager) {
		if (!questionManager.getQuestionBank().isEmpty()) {
			System.out.println("All Questions:");
			for (int i = 0; i < questionManager.getQuestionBank().size(); i++) {
				Question question = questionManager.getQuestionBank().get(i);
				System.out.println((i + 1) + ". " + question.getQuestion());
				System.out.println("Options: " + String.join(", ", question.getOptions()));
			}
		} else {
			System.out.println("No questions available.");
		}
	}

	private static void editQuestion(Scanner scanner, QuestionManager questionManager) {
		if (questionManager.getQuestionBank().isEmpty()) {
			System.out.println("No questions available to edit.");
			return;
		}
		viewQuestions(questionManager);
		System.out.println("Enter the index of the question you want to edit:");
		int indexToEdit = scanner.nextInt();
		scanner.nextLine(); // Consume new line
		if (indexToEdit >= 1 && indexToEdit <= questionManager.getQuestionBank().size()) {
			Question question = questionManager.getQuestionBank().get(indexToEdit - 1);
			System.out.println("Enter the new question text:");
			String newQuestionText = scanner.nextLine();
			question.setQuestion(newQuestionText);

			System.out.println("Enter the new options (comma-separated):");
			String newOptionsInput = scanner.nextLine();
			String[] newOptions = newOptionsInput.split(",");
			// Convert String[] to List<String>
			List<String> optionsList = Arrays.asList(newOptions);
			question.setOptions(optionsList);

			// Loop to ensure a valid correct option index is entered
			int newCorrectOptionIndex;
			do {
				System.out.println("Enter the index of the new correct option:");
				newCorrectOptionIndex = scanner.nextInt();
				scanner.nextLine(); // Consume new line
				if (newCorrectOptionIndex < 1 || newCorrectOptionIndex > newOptions.length) {
					System.out.println("Invalid correct option index. Please try again.");
				}
			} while (newCorrectOptionIndex < 1 || newCorrectOptionIndex > newOptions.length);

			question.setCorrectAnswerIndex(newCorrectOptionIndex - 1);
			System.out.println("Question edited successfully.");
		} else {
			System.out.println("Invalid index.");
		}
	}

	private static void deleteQuestion(Scanner scanner, QuestionManager questionManager) {
		if (questionManager.getQuestionBank().isEmpty()) {
			System.out.println("No questions available to delete.");
			return;
		}
		viewQuestions(questionManager);
		System.out.println("Enter the index of the question you want to delete:");
		int indexToDelete = scanner.nextInt();
		scanner.nextLine(); // Consume new line
		if (indexToDelete >= 1 && indexToDelete <= questionManager.getQuestionBank().size()) {
			questionManager.getQuestionBank().remove(indexToDelete - 1);
			System.out.println("Question deleted successfully.");
		} else {
			System.out.println("Invalid index.");
		}
	}

	private static void addQuestion(Scanner scanner, QuestionManager questionManager) {
		System.out.println("Enter the question:");
		scanner.nextLine(); // Consume new line
		String questionText = scanner.nextLine();
		System.out.println("Enter the options (comma-separated):");
		String optionsInput = scanner.nextLine();
		String[] options = optionsInput.split(",");
		System.out.println("Enter the index of the correct option:");
		int correctOptionIndex = scanner.nextInt();
		scanner.nextLine(); // Consume new line
		if (correctOptionIndex >= 1 && correctOptionIndex <= options.length) {
			Question question = new Question(0, questionText, List.of(options), correctOptionIndex - 1);
			questionManager.getQuestionBank().add(question);
			System.out.println("Question added successfully.");
		} else {
			System.out.println("Invalid option index.");
		}
	}
}
