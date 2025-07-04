package Elevatelab;

import java.util.*;

class Question {
    String question;
    List<String> options;
    int correctAnswerIndex; // 0-based index

    public Question(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer - 1 == correctAnswerIndex;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(
            "What is the capital of India?",
            Arrays.asList("Mumbai", "Delhi", "Chennai", "Kolkata"),
            1));
        questionList.add(new Question(
            "Which language is used for Android Development?",
            Arrays.asList("Python", "Kotlin", "Swift", "C++"),
            1));
        questionList.add(new Question(
            "Which data structure uses FIFO?",
            Arrays.asList("Stack", "Queue", "Tree", "Graph"),
            1));
        questionList.add(new Question(
            "Which keyword is used to inherit a class in Java?",
            Arrays.asList("implements", "extends", "inherit", "this"),
            1));
        questionList.add(new Question(
            "What is the default value of int in Java?",
            Arrays.asList("0", "null", "undefined", "1"),
            0));

        // 🔀 Shuffle the questions
        Collections.shuffle(questionList);

        int score = 0;
        int questionNumber = 1;

        Iterator<Question> iterator = questionList.iterator();
        while (iterator.hasNext()) {
            Question q = iterator.next();
            System.out.println("\nQuestion " + questionNumber + ":");
            q.displayQuestion();
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect! Correct answer: " + (q.correctAnswerIndex + 1) + ". " + q.options.get(q.correctAnswerIndex));
            }
            questionNumber++;
        }

        // 📝 Final Result
        System.out.println("\n🎯 Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questionList.size());

        scanner.close();
    }
}
