package decorator;

/**
 * Smile decor for the car that gives it a smile
 * @author Jesse Caro
 */
public class Smile extends VehicleDecorator {
    /**
     * Creates a smile object that wraps the car
     * @param vehicle the vehicle that is getting a smile
     */
    public Smile(Vehicle vehicle) {
        super(vehicle.lines);
        integrateDecor(FileReader.getLines("decorator/txt/smile.txt"));
    }
}
