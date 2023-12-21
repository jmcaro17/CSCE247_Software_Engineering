package strategy;

import java.util.Random;

/**
 * Defines Quarterback class, child of player
 * @author Jesse Caro
 */
public class QuarterBack extends Player {
    /**
     * Creates a new quarterback
     * @param firstName Quarterbacks first name
     * @param lastName Quarterbacks last name
     * @param offense Boolean wether or not 
     */
    public QuarterBack(String firstName, String lastName, boolean offense) {
        super(firstName, lastName, offense);
    }

    /**
     * Chooses either run or pass behavior
     */
    public void setOffenseBehavior() {
        Random rand = new Random();
        int randy = rand.nextInt(2);
        if(randy == 0) {
            offenseBehavior = new RunBehavior();
        } else {
            offenseBehavior = new PassBehavior();
        }
    }

    /**
     * Defense behavior set to null
     */
    public void setDefenseBehavior() {
        defenseBehavior = null;
    }

}
