class Scorecard {
    private boolean[] results;
    private final int totalQuestions;
    private int answerCount;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.answerCount = 0;
    }

    public void recordAnswer(boolean result) {
        if (answerCount < totalQuestions) {
            results[answerCount] = result;
            answerCount++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}
