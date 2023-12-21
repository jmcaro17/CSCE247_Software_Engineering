package factory;

/**
 * A Strider that is a child of Bike
 * @author Jesse Caro
 */
public class Strider extends Bike {
    /**
     * Creates a Strider with its attributes
     */
    public Strider() {
        this.name = "Strider";
        this.numWheels = 2;
        this.hasPeddals = false;
        this.hasTrainingWheels = false;
    }
}
