package decorator;

/**
 * Rims decor for the car that gives it nice rims
 * @author Jesse Caro
 */
public class Rims extends VehicleDecorator {
    /**
     * Creates a rims object that wraps the car
     * @param vehicle the vehicle that is getting new rims
     */
    public Rims(Vehicle vehicle) {
        super(vehicle.lines);
        integrateDecor(FileReader.getLines("decorator/txt/rims.txt"));
    }
}
