import java.util.*;

abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    abstract String getType();
}

class MCQQuestion extends Question {
    MCQQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    TFQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String answer = studentAnswer.toLowerCase();

        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String keyword : keywords) {
            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    String getType() {
        return "ESSAY";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            List<String> parts = new ArrayList<>();
            boolean insideQuotes = false;
            StringBuilder current = new StringBuilder();

            for (char c : line.toCharArray()) {
                if (c == '"') {
                    insideQuotes = !insideQuotes;
                } else if (c == ' ' && !insideQuotes) {
                    if (current.length() > 0) {
                        parts.add(current.toString());
                        current.setLength(0);
                    }
                } else {
                    current.append(c);
                }
            }

            if (current.length() > 0) {
                parts.add(current.toString());
            }

            String type = parts.get(0);
            String correctAnswer = parts.get(2);
            String studentAnswer = parts.get(3);
            double points = Double.parseDouble(parts.get(4));

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion(
                    correctAnswer, studentAnswer, points
                );
            } else if (type.equals("TF")) {
                question = new TFQuestion(
                    correctAnswer, studentAnswer, points
                );
            } else {
                question = new EssayQuestion(
                    correctAnswer, studentAnswer, points
                );
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
