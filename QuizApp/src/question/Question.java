package question;

import java.util.List;

public class Question {
	private int qid;
	private String question;
	private List<String> options;
	private int correctAnswerIndex;

	public Question(int qid, String question, List<String> options, int correctAnswerIndex) {
		this.qid = qid;
		this.question = question;
		this.options = options;
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public int getQid() {
		return qid;
	}

	public String getQuestion() {
		return question;
	}

	public List<String> getOptions() {
		return options;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}

}
