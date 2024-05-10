package question;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
	private List<Question> questionBank;

	public QuestionManager() {
		questionBank = new ArrayList<>();
		initializeQuestions();
	}

	private void initializeQuestions() {
		questionBank.add(new Question(1, "What is Java?",
				List.of("A programming language", "A car manufacturer", "An operating system", "A brand of book"), 0));

		questionBank.add(new Question(2, "What is the output of 'System.out.println(5 + 3 + \"Java\")'?",
				List.of("8", "53Java", "8Java", "5 + 3 + Java"), 2));
		questionBank.add(new Question(3, "What does JDBC stands for?", List.of("Java DataBase Control",
				"Java DataBase Connectivity", "JavaScript Database Connectivity", "Java DataBase Control"), 1));
		questionBank.add(new Question(4, "Which interface is used to execute SQL queries in JDBC?",
				List.of("Statement", "ResultSet", "Connection", "PreparedStatement"), 0));
	}

	public List<Question> getQuestionBank() {
		return questionBank;
	}
}
