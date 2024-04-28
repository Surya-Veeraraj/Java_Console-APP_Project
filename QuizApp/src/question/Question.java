package question;

import java.util.List;

public class Question {
    private int qid;
    private String question;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(int qid, String question, List<String> options, int correctAnswerIndex) {

        if (qid < 0) {
            throw new IllegalArgumentException("Question ID must be non-negative.");
        }
        if (correctAnswerIndex < 0 || correctAnswerIndex >= options.size()) {
            throw new IllegalArgumentException("Correct answer index is out of bounds.");
        }
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
        if (correctAnswerIndex < 0 || correctAnswerIndex >= options.size()) {
            throw new IllegalArgumentException("Correct answer index is out of bounds.");
        }
        this.correctAnswerIndex = correctAnswerIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question ").append(qid).append(": ").append(question).append("\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append((i + 1)).append(". ").append(options.get(i)).append("\n");
        }
        sb.append("Correct answer: ").append(correctAnswerIndex + 1);
        return sb.toString();
    }
}
