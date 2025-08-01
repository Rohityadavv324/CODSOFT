import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int rounds = 0, score = 0;
        boolean playAgain;
        do {
            int number = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0, guess = 0;
            System.out.println("Guess a number between 1 and 100:");
            while (attempts < 7) {
                guess = sc.nextInt();
                attempts++;
                if (guess == number) {
                    System.out.println("Correct! You guessed in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess > number) {
                    System.out.println("Too high.");
                } else {
                    System.out.println("Too low.");
                }
            }
            if (guess != number)
                System.out.println("Sorry! The number was: " + number);
            System.out.println("Do you want to play again? (true/false)");
            playAgain = sc.nextBoolean();
            rounds++;
        } while (playAgain);
        System.out.println("Rounds played: " + rounds + " | Score: " + score);
        sc.close();
    }
}
