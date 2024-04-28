package roles;

import java.util.Scanner;

import question.Question;
import question.QuestionManager;

public class StudentActions {
    private int score;
    private QuestionManager questionManager;

    public StudentActions(QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

    public void takeQuiz(Scanner scanner) {
        for (Question question : questionManager.getQuestionBank()) {
            System.out.println(question.getQuestion());
            System.out.println("Options:");
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }

            System.out.print("Your answer (Enter option number or type 'skip' to skip): ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("skip")) {
                System.out.println("Question skipped.");
                continue;
            }

            try {
                int userChoice = Integer.parseInt(userInput) - 1;
                if (userChoice >= 0 && userChoice < question.getOptions().size()) {
                    if (question.getCorrectAnswerIndex() == userChoice) {
                        score += 2;
                        System.out.println("Correct! +2 marks");
                    } else {
                        score -= 1;
                        System.out.println("Wrong! -1 mark");
                    }
                } else {
                    System.out.println("Invalid option. Skipping question.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Skipping question.");
            }
        }

        System.out.println("Quiz completed! Your score: " + score);
    }
}
