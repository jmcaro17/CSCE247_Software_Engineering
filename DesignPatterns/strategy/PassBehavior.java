package strategy;
import java.util.Random;

/**
 * Decides which pass is thrown
 * @author Jesse Caro
 */
public class PassBehavior implements OffenseBehavior {
    Random rand = new Random();
    private String[] passes = { "slant route", "out route", "seem route", "screen pass", "hail mary" };
    
    /**
     * Chooses random route to throw
     * @return a string of what pass was thrown on the play
     */
    public String play() {
        return "throws a " + passes[rand.nextInt(passes.length)];
    }
}
