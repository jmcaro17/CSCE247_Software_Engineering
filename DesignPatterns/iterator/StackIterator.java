package iterator;

import java.util.Iterator;
import java.util.Stack;

/**
 * An iterator class for a stack
 * @author Jesse Caro
 */
public class StackIterator implements Iterator<String> {
    private Stack<String> items;
    private int position = 0;

    /**
     * Creates a StackIterator with a stack of items
     * @param items the items in the stack we are iterating
     */
    public StackIterator(Stack<String> items) {
        this.items = items;
    }

    /**
     * Gets the next item
     * @return the item
     */
    public String next() {
        return items.get(position++);
    }

    /**
     * Checks if theres more items left in the stack
     * @return wether or not there is a next item in the stack
     */
    public boolean hasNext() {
        return position < items.size();
    }

}
