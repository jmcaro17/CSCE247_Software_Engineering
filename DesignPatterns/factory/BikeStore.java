package factory;

/**
 * A Bike Store that makes three different types of bikes
 * @author Jesse Caro
 */
public class BikeStore {
    /**
     * creates the bike of the type it is sent
     * @param type the type of bike to create
     * @return the newly created bike
     */
    public Bike createBike(String type) {
        if(type.equals("strider")) {
            return new Strider();
        } else if (type.equals("kids bike")) {
            return new KidsBike();
        } else if (type.equals("tricycle")) {
            return new Tricycle();
        }

        return null;
    }
}
