package decorator;

import java.util.ArrayList;

/**
 * A vehicle that has an arraylist that displays its image
 * @author Jesse Caro
 */
public abstract class Vehicle {
    protected ArrayList<String> lines;

    /**
     * Creates a vehicle with a text file to display its image
     * @param lines an array list of strings from a file
     */
    public Vehicle(ArrayList<String> lines){
        this.lines = lines;
        lines.get(0);
    }

    /**
     * Turns the vehicle to a string so we can print it and see the vehicle
     * @return a concatenated string of the arraylist lines together
     */
    public String toString(){
        String ret = "";
        for(String line : lines) {
            ret += line + "\n";
        }
        return ret;
    }
}
