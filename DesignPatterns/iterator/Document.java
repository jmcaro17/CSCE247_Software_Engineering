package iterator;

import java.util.Stack;

/**
 * A text document that we can edit
 * @author Jesse Caro
 */
public class Document {
    private String title;
    private Stack<String> undoStack = new Stack<String>();
    private Stack<String> redoStack = new Stack<String>();

    /**
     * Creates a document with a title
     */
    public Document(String title) {
        this.title = title;
    }

    /**
     * Makes an edit to the document
     * @param change the change to make
     * @return the change that was made
     */
    public String makeChange(String change) {
        undoStack.push(change);
        return "Making Change " + change;
    }

    /**
     * Undo your last change
     * @return the change that was undone
     */
    public String undoChange() {
        String ret = undoStack.pop();
        redoStack.push(ret);
        return "Undoing: " + ret;
    }

    /**
     * Checks if there is a change in the undoStack
     * @return wether or not there is a change that can be undone
     */
    public boolean canUndo() {
        return !(undoStack.empty());
    }

    /**
     * redoes the last undone change
     * @return the change that was redone
     */
    public String redoChange() {
        String ret = redoStack.pop();
        undoStack.push(ret);
        return "Redoing: " + ret;
    }

    /**
     * Checks if there is a change in the redoStack
     * @return wether or not there is a change that can be redone
     */
    public boolean canRedo() {
        return !(redoStack.empty());
    }

    /**
     * Gets the undoStackIterator
     * @return the undoStackIterator
     */
    public StackIterator getUndoIterator() {
        return new StackIterator(undoStack);
    }

    /**
     * Gets the redoStackIterator
     * @return the redoStackIterator
     */
    public StackIterator getRedoIterator() {
        return new StackIterator(redoStack);
    }
}
