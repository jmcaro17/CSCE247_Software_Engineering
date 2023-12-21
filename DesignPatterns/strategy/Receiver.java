package strategy;

public class Receiver extends Player {
    /**
     * Creates a new receiver
     * @param firstName Receivers first name
     * @param lastName Receivers last name
     * @param offense Boolean wether receiver is on offense or not
     */
    public Receiver(String firstName, String lastName, boolean offense) {
        super(firstName, lastName, offense);
    }

    /**
     * Sets offense behavior to receive behavior
     */
    public void setOffenseBehavior() {
        offenseBehavior = new RecieveBehavior();
    }

    /**
     * Sets defense behavior to null
     */
    public void setDefenseBehavior() {
        defenseBehavior = null;
    }
}
