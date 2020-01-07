package app;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        // Create game's object
        Hangman hangman = new Hangman(7);

        // new Scanner to read inputs
        Scanner in = new Scanner(System.in);

        // Create List of words to be choosen
        List<String> words = Arrays.asList("SALAD", "BREAD", "HOUSE", "BIIIIIIIIIIG", "BEER", "MONKEY", "PEPSI");

        // Create a random number from the size of the List
        int randomNumber = new Random().nextInt(words.size());

        // Create the secret word generated randomly from the List
        String secretWord = words.get(randomNumber);

        // Create the game with Characters for the secret word
        char[] game = new char[secretWord.length()];

        // print Games
        System.out.println("Welcome to Hangman!");

        // fill the game word with dashes
        hangman.fillGame(game);

        // display the game
        hangman.displayGame(game);

        // Infinite loop for the game to work
        while (true) {

            // check if the word is completed or not
            hangman.isTheWordCompleted(game, secretWord);

            // exit game if win or word completed
            if (hangman.getGuesses() == 0 || hangman.isWin() == true) {
                break;

            }

            // if guesses = 1 one left message
            if (hangman.getGuesses() == 1) {
                System.out.println("\nCarefull, you have only one guess left.");

            } else {
                System.out.println("\nYou have " + hangman.getGuesses() + " guesses left.");
            }

            System.out.print("Your guess: ");
            // user plays
            String user = in.next().toUpperCase();

            char userLetter = user.charAt(0);

            hangman.findLetter(game, userLetter, secretWord);
            System.out.print("The word now looks like this: ");
            hangman.displayGame(game);
            System.out.println();

        } // end while loop

        // end game
        if (hangman.isTheWordCompleted(game, secretWord)) {
            System.out.println("\nCongratulations you found the word!!");
        }

        else

        {
            System.out.println("\nThe word was " + secretWord);
            System.out.println("\nYou lost.. Sorry better luck next time");
        }

    }

}