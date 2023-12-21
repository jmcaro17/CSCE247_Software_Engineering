package observer;

/**
 * A subject with observers that can be added, removed, and notified
 * @author Jesse Caro
 */
public interface Subject {
    public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers(int strokes, int par);
}
