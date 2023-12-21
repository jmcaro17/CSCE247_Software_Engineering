package strategy;

import java.util.Random;

/**
 * Defines Lineman Class, child of player
 * @author Jesse Caro
 */
public class Lineman extends Player {
    /**
     * Creates a new Lineman
     * @param firstName Linemans first name
     * @param lastName Linemans last name
     * @param offense Boolean wether Lineman is on offense or not
     */
    public Lineman(String firstName, String lastName, boolean offense) {
        super(firstName, lastName, offense);
    }

    public void setOffenseBehavior() {
        offenseBehavior = new OBlockBehavior();
    }

    /**
     * Chooses random Defensive Behavior between block, strip, and sack
     */
    public void setDefenseBehavior() {
        Random rand = new Random();
        int randy = rand.nextInt(3);
        if(randy == 0) {
            defenseBehavior = new BlockBehavior();
        } else if(randy == 1) {
            defenseBehavior = new StripBehavior();
        } else {
            defenseBehavior = new SackBehavior();
        }
    }
}
