package decorator;

/**
 * A car that is the child of a vehicle
 * @author Jesse Caro
 */
public class Car extends Vehicle {
    /**
     * Creates a car using its parent vehcile constructor and the car.txt file made into an arraylist of strings
     */
    public Car() {
        super(FileReader.getLines("decorator/txt/car.txt"));
    }
}
