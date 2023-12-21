package observer;

import java.util.ArrayList;

/**
 * A golfer with observers
 * @author Jesse Caro
 */
public class Golfer implements Subject {
    private ArrayList<Observer> observers;
    private String name;

    /**
     * Creates a new Golfer with a name and an arraylist of observers
     * @param name The golfers name
     */
    public Golfer(String name) {
        observers = new ArrayList<Observer>();
        this.name = name;
    }

    /**
     * Adds an observer to the array list
     * @param observer Observer object to be added
     */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer to the array list
     * @param observer Observer object to be added
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifys each observer of the golfer in the arraylist to update with a new hole
     * @param strokes Number of strokes on the hole
     * @param par Par on the hole
     */
    public void notifyObservers(int strokes, int par) {
        for(Observer observer : observers) {
            observer.update(strokes, par);
        }
    }

    /**
     * Enters the score to notify each observer
     * @param strokes Number of strokes on the hole
     * @param par Par on the hole
     */
    public void enterScore(int strokes, int par) {
        notifyObservers(strokes, par);
    }

    /**
     * Gets the golfer's name
     * @return the name of the golfer
     */
    public String getName() {
        return this.name;
    }
}
