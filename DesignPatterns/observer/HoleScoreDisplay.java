package observer;

/**
 * Display for the current hole
 * @author Jesse Caro
 */
public class HoleScoreDisplay implements Observer {
    private Subject golfer;
    private int strokes;
    private int par;

    /**
     * Creates a HoleScoreDisplay for the golfer it is called on
     * @param golfer the golfer for this display
     */
    public HoleScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        this.golfer.registerObserver(this);
    }

    /**
     * Updates par and stroke for the next hole
     * @param strokes number of strokes taken on hole to be updated
     * @param par the par for the hole to be updated
     */
    public void update(int strokes, int par) {
        this.strokes = strokes;
        this.par = par;
        toString();
    }

    /**
     * The string version of the statistics for this hole
     * @return a string that displays the par and number of strokes on the hole as well as how much you were under or over par, or if you made par
     */
    public String toString() {
        if (this.strokes > this.par) {
            return "\nCurrent hole stats: Par (" + this.par + ") Strokes (" + this.strokes + "), " + (strokes - par) + " over par\n";
        } else if (this.par > this.strokes) {
            return "\nCurrent hole stats: Par (" + this.par + ") Strokes (" + this.strokes + "), " + (par - strokes) + " under par\n";
        } else {
            return "\nCurrent hole stats: Par (" + this.par + ") Strokes (" + this.strokes + "), Made par\n";
        }
    }
}