package strategy;

import java.util.Random;

/**
 * Decides which route is ran
 * @author Jesse Caro
 */
public class RecieveBehavior implements OffenseBehavior {
    Random rand = new Random();
    private String[] routes = { "slant route", "out route", "seem route", "screen pass", "hail mary" };
    
    /**
     * Chooses random route to throw
     * @return a string of what route was ran on the play
     */
    public String play() {
        return "runs a " + routes[rand.nextInt(routes.length)];
    }  
}
