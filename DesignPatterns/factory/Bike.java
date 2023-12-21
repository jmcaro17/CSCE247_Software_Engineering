package factory;

/**
 * A bike with pedals, wheels, a price, and a name
 * @author Jesse Caro
 */
public abstract class Bike {
    protected String name;
    protected double price;
    protected int numWheels;
    protected boolean hasPeddals;
    protected boolean hasTrainingWheels;

    /**
     * Adds all the different parts to the bike
     * @return a string of the process to assemble the bike
     */
    public String assembleBike() {
        String gap = "\n- ";
        String ret = "Creating a " + name + gap + this.createFrame() + gap + this.addWheels();
        if(this.addPedals() != null) {
            return ret + gap + this.addPedals();
        }
        
        return ret;
    }

    /**
     * Adds the bike frame
     * @return a string for the frame of the bake
     */
    private String createFrame() {
         return "Assembling " + name + " frame";
    }

    /**
     * Adds the bikes wheels
     * @return a string for the wheels on the bike
     */
    private String addWheels() {
        String ret = "Adding " + numWheels + " wheel(s)";
        
        if(hasTrainingWheels) {
            return ret + "\n- Adding training wheels";
        }
        
        return ret;
    }

    /**
     * Adds the bikes peddals
     * @return a string for the peddals on the bike
     */
    private String addPedals() {
        if(hasPeddals) {
            return "Adding pedals";
        }
        
        return null;
    }

    /**
     * Gets the price of the bike
     * @return the bikes price
     */
    public double getPrice() {
        return price;
    }
}
