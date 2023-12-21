package decorator;

import java.util.ArrayList;

/**
 * A VehicleDecorator class that is a child of the Vehicle that adds decoration to the vehicle
 * @author Jesse Caro
 */
public abstract class VehicleDecorator extends Vehicle {
    /**
     * Creates a VehicleDecorator using its parents vehicle constructor
     * @param lines the arraylist of lines that show the image of the vehicle that we will add decorations to
     */
    public VehicleDecorator(ArrayList<String> lines) {
        super(lines);
    }

    /**
     * A function to add decor to a vehicle
     * @param decor the arraylist of strings that have the decor we are adding to the vehicle
     */
    protected void integrateDecor(ArrayList<String> decor) {
        String temp = "";
        for(int i = 0; i < lines.size() - 1; ++i) {
            for(int j = 0; j < lines.get(i).length(); ++j) {
                if((lines.get(i).charAt(j) == ' ' && decor.get(i).charAt(j) != ' ') || (lines.get(i).charAt(j) != ' ' && decor.get(i).charAt(j) != ' ')) {
                    temp = lines.get(i).substring(0, j) + decor.get(i).charAt(j) + lines.get(i).substring(j+1);
                    lines.set(i, temp);
                }
            }
        }
    }
}
