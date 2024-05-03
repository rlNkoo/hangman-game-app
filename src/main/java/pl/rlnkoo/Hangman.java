package pl.rlnkoo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    List<String> words = List.of("umbrella", "elephant", "computer", "fireworks",
            "sunshine", "butterfly", "adventure", "chocolate", "guitar", "rainbow");

    String word;
    char[] userWord;
    int lives = 5;

    public void play() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Enter a letter: ");
            System.out.println("Lives left: " + lives);

            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);
        }
        if (lives == 0) {
            System.out.println("Game ended - You lose :(");
        } else {
            System.out.println("Congratulations - You win! :)");
        }
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord[i] = letter;
                foundLetter = true;
            }
        }
        if (!foundLetter) {
            System.out.println("Wrong letter");
            lives--;
        }
    }

    private boolean gameEnded() {
        return lives ==0 || word.equals(String.valueOf(userWord));
    }


}
