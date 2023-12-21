package observer;

/**
 * An observer of a golf match
 * @author Jesse Caro
 */
public interface Observer {
    public void update(int strokes, int par);
    public String toString();
}
