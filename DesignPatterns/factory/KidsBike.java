package factory;

/**
 * A Kids Bike that is a child of Bike
 * @author Jesse Caro
 */
public class KidsBike extends Bike {
    /**
     * Creates a KidsBike with its attributes
     */
    public KidsBike() {
        this.name = "Kids Bike";
        this.numWheels = 2;
        this.hasPeddals = false;
        this.hasTrainingWheels = true;
    }
    
}
