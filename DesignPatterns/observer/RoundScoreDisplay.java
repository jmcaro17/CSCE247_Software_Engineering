package observer;

/**
 * Display for the running total of the game
 * @author Jesse Caro
 */
public class RoundScoreDisplay implements Observer {
    private Subject golfer;
    private int strokesTotal;
    private int parTotal;

    /**
     * Creates a RoundScoreDisplay for the golfer it is called on
     * @param golfer the golfer for this display
     */
    public RoundScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        this.golfer.registerObserver(this);
    }

    /**
     * Updates par and stroke totals for the next hole
     * @param strokes number of strokes taken on hole to be updated and added to total
     * @param par the par for the hole to be updated and added to total
     */
    public void update(int strokes, int par) {
        this.strokesTotal += strokes;
        this.parTotal += par;
        toString();
    }

    /**
     * The string version of the running statistics for the game
     * @return a string that displays the par and stroke totals for the game as well as how much you are under or over par, or if you are making par
     */
    public String toString() {
        if (this.strokesTotal > this.parTotal) {
            return "Overall stats: Par (" + this.parTotal + ") Strokes (" + this.strokesTotal + "), " + (strokesTotal - parTotal) + " over par\n";
        } else if (this.parTotal > this.strokesTotal) {
            return "Overall stats: Par (" + this.parTotal + ") Strokes (" + this.strokesTotal + "), " + (parTotal - strokesTotal) + " under par\n";
        } else {
            return "Overall stats: Par (" + this.parTotal + ") Strokes (" + this.strokesTotal + "), Making par\n";
        }
    }
}