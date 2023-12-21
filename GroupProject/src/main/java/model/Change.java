package model;

import java.util.Date;

/**
 * The Change class represents a change with a note and a date.
 */
public class Change {
    private String note;
    private Date date;

    /**
     * Constructor to create a new Change instance with a note and a date.
     *
     * @param note The note associated with the change.
     * @param date The date when the change occurred.
     */
    public Change(String note, Date date) {
        this.note = note;
        this.date = date;
    }

    /**
     * Get the note associated with the change.
     *
     * @return The note of the change.
     */
    public String getNote() {
        return note;
    }

    /**
     * Get the date when the change occurred.
     *
     * @return The date of the change.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Return a string representation of the change, including the note and date.
     *
     * @return A string representing the change in the format "note at date".
     */
    public String toString() {
        return note + " at " + date;
    }
}
