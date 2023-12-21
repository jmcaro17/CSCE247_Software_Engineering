package decorator;

import java.util.HashMap;
/**
 * Paint decor for the car that changes its color
 * @author Jesse Caro
 */
public class Paint extends VehicleDecorator {
    private static final String TEXT_RESET = "\u001B[0m";
    private HashMap<String,String> colorMap = new HashMap<String,String>();
    
    /**
     * Creates a paint object that wraps the car
     * @param vehicle the vehicle that is changing its color
     * @param color the string of the color we are changing the car to
     */
    public Paint(Vehicle vehicle, String color) {
        super(vehicle.lines);
        colorMap.put("black", "\u001B[0m");
        colorMap.put("red", "\u001B[31m");
        colorMap.put("green", "\u001B[32m");
        colorMap.put("yellow", "\u001B[33m");
        colorMap.put("blue", "\u001B[34m");
        colorMap.put("purple", "\u001B[35m");
        colorMap.put("cyan", "\u001B[36m");
        colorVehicle(color);
    }

    /**
     * Helper function that uses the hashmap to change the color of the car
     * @param color the color we are changing the car to
     */
    private void colorVehicle(String color){
        
        if(colorMap.containsKey(color.toLowerCase())) {
            String colorCode = colorMap.get(color.toLowerCase());
            String firstLine = lines.get(0);
            lines.set(0, colorCode + firstLine);
            String lastLine = lines.get(lines.size()-1);
            lines.set(lines.size()-1, lastLine + TEXT_RESET);
        }
    }
}
