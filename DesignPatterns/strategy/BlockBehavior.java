package strategy;
import java.util.Random;

/**
 * Chooses what gets blocked
 * @author Jesse Caro
 */
public class BlockBehavior implements DefenseBehavior {
    Random rand = new Random();
    private String[] blocks = { "kick", "punt", "pass", "catch" };
    
    /**
     * Creates string representation of whats blocked
     * @return a string letting the user know what was blocked on the play
     */
    public String play() {
        return "block a " + blocks[rand.nextInt(blocks.length)];
    }
}
