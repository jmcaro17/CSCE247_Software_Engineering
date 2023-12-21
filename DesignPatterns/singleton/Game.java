package singleton;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * a singleton game that is an anagram game with varying difficulty and a score tracker
 * @author Jesse Caro
 */
public class Game {
    private static Game game;
    private Random rand = new Random();
    private Difficulty level;
    private HashMap<Difficulty, ArrayList<Anagram>> anagrams = new HashMap<Difficulty, ArrayList<Anagram>>();
    private Anagram currentAnagram;
    private int score;

    /**
     * thie constructs the game by filling the hasshmap and starts on the easy level
     */
    private Game() {
        anagrams.put(Difficulty.EASY, FileReader.getAnagrams(Difficulty.EASY));
        anagrams.put(Difficulty.MEDIUM, FileReader.getAnagrams(Difficulty.MEDIUM));
        anagrams.put(Difficulty.HARD, FileReader.getAnagrams(Difficulty.HARD));
        level = Difficulty.EASY;
    }

    /**
     * checks if there is a game if not, creates a game and then returns the game
     * @return the single instance of this game
     */
    public static Game getInstance() {
        if (game == null) {
            System.out.println("Creating a new game");
            game = new Game();
        }
        return game;
    }

    /**
     * checks the score to set difficulty, sets the current anagram to a random
     * one based of the difficulty, and returns the current anagrams question
     * @return a string of the question for the current anagram
     */
    public String getQuestion() {
        if(getScore() < 4) {
            level = Difficulty.EASY;
        } else if(getScore() < 7) {
            level = Difficulty.MEDIUM;
        } else {
            level = Difficulty.HARD;
        }
        currentAnagram = anagrams.get(level).get(rand.nextInt(anagrams.get(level).size()));
        return currentAnagram.getQuestion();
    }

    /**
     * checks if the users answer is correct, updates the score,
     * and returns a boolean for the correctness of the answer
     * @param userAnswer the input from the user as their guess for the anagram
     * @return true or false for if the users answer was a correct answer or not
     */
    public boolean isCorrect(String userAnswer) {
        if(currentAnagram.isCorrect(userAnswer)) {
            score++;
            return true;
        }
        score--;
        return false;
    }

    /**
     * gets the score of the game
     * @return the score
     */
    public int getScore() {
        return score;
    }
}
