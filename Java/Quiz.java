package Java;
import java.util.Scanner; // Imports the Scanner Method.

public class Quiz {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // Creates the Scanner Object.
        int userScore = 0; // Creates the score of the user for each correct answer.

        // Array of the quiz questions.
        String[] questions = {
            "\nQuestion 1: What is the capital of France?\nA. Berlin\nB. Madrid\nC. Paris\nD. Rome",
            "\nQuestion 2: Which planet is known as the Red Planet?\nA. Earth\nB. Venus\nC. Mars\nD. Jupiter",
            "\nQuestion 3: Who wrote 'Hamlet'?\nA. Charles Dickens\nB. William Shakespeare\nC. Mark Twain\nD. Leo Tolstoy",
            "\nQuestion 4: What is the largest mammal?\nA. Elephant\nB. Giraffe\nC. Blue Whale\nD. Hippopotamus",
            "\nQuestion 5: What is 5 + 7?\nA. 10\nB. 11\nC. 12\nD. 13"
        };

        // Array of the correct answers of each question of the quiz.
        String[] correctAnswers = { "C", "C", "B", "C", "C" };

        // Loop for each question.
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]); // Displays the questions to the user.
            String userAnswer = input(userInput); // Generates the user input.

            // Switch for checking if the answers the user has given are correct.
            switch (userAnswer.toUpperCase()) {
                case "A":
                case "B":
                case "C":
                case "D":
                    if (userAnswer.equalsIgnoreCase(correctAnswers[i])) {
                        userScore++;
                    }
                    break;
                default:
                    System.out.println("Invalid input! Counting as incorrect."); // Prevents the input of incorrect answers.
            }
        }

        // Calculation and display of the user's score as percentage.
        double scorePercentage = ((double) userScore / questions.length) * 100;
        System.out.println("Your final score: " + scorePercentage + "%");

        userInput.close(); // Close the Scanner.
    }

    public static String input(Scanner sc) {
        System.out.print("Enter your answer: ");
        return sc.nextLine();
    }
}
