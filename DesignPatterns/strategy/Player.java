package strategy;

/**
 * A player on a football team
 * @author Jesse Caro
 */
public abstract class Player {

    private String firstName;
    private String lastName;
    private boolean offense;
    protected DefenseBehavior defenseBehavior;
    protected OffenseBehavior offenseBehavior;

    /**
     * Creates a new player with the specified paramaters
     * @param firstName Players first name
     * @param lastName Players last name
     * @param offense Boolean if they are on offense or not
     */
    public Player(String firstName, String lastName, boolean offense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.offense = offense;
    }

    public abstract void setDefenseBehavior();

    public abstract void setOffenseBehavior();

    /**
     * executes a play for the team
     * @return returns an offensive play or defensive play depending on the teams side
     */
    public String play() {
        setDefenseBehavior();
        setOffenseBehavior();

        if(offense) {
            if(offenseBehavior == null)
                return "not playing";
            return offenseBehavior.play();
        } else {
            if(defenseBehavior == null)
                return "not playing";
            return defenseBehavior.play();
        }
    }

    /**
     * Switches sides
     */
    public void turnover() {
        offense = !offense;
    }

    /**
     * Creates a string representation of the player
     * @return a string version of the player, letting the user nown their name
     */
    public String toString() {
        return firstName + " " + lastName;
    }

}
