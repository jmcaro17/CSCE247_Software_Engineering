package factory;

/**
 * A Tricycle that is a child of Bike
 * @author Jesse Caro
 */
public class Tricycle extends Bike {
    /**
     * Creates a Tricycle with its attributes
     */
    public Tricycle() {
        this.name = "Tricycle";
        this.numWheels = 3;
        this.hasPeddals = true;
        this.hasTrainingWheels = false;
    }

}
