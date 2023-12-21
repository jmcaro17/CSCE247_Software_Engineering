package strategy;

import java.util.Random;

/**
 * Decides which run play is ran
 * @author Jesse Caro
 */
public class RunBehavior implements OffenseBehavior {
    Random rand = new Random();
    private String[] runs = { "drive (up the gut)", "draw", "pitch", "reverse" };
    
    /**
     * Chooses random route to throw
     * @return a string of what run play was ran
     */
    public String play() {
        return "runs a " + runs[rand.nextInt(runs.length)];
    }
}
