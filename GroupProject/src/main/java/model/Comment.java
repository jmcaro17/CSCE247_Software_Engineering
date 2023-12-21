package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * The Comment class represents a user comment with optional replies.
 */
public class Comment {
    private String note;
    private User user;
    private Date date;
    private ArrayList<Comment> replies = new ArrayList<Comment>();

    /**
     * Constructor to create a new Comment with a note, user, and date.
     *
     * @param note The comment text.
     * @param user The user who made the comment.
     * @param date The date when the comment was made.
     */
    public Comment(String note, User user, Date date) {
        this.note = note;
        this.user = user;
        this.date = date;
    }

    /**
     * Constructor to create a new Comment with a note, user, date, and replies.
     *
     * @param note    The comment text.
     * @param user    The user who made the comment.
     * @param date    The date when the comment was made.
     * @param replies A list of replies to this comment.
     */
    public Comment(String note, User user, Date date, ArrayList<Comment> replies) {
        this.note = note;
        this.user = user;
        this.date = date;
        this.replies = replies;
    }

    /**
     * Get the text content of the comment.
     *
     * @return The text content of the comment.
     */
    public String getNote() {
        return note;
    }

    /**
     * Edit the text content of the comment.
     *
     * @param note The new text content for the comment.
     * @return The updated text content.
     */
    public String editNote(String note) {
        this.note = note;
        return note;
    }

    /**
     * Get the user who made the comment.
     *
     * @return The user who made the comment.
     */
    public User getUser() {
        return user;
    }

    /**
     * Get the date when the comment was made.
     *
     * @return The date when the comment was made.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Edit the date when the comment was made.
     *
     * @param date The new date for the comment.
     * @return The updated date.
     */
    public Date editDate(Date date) {
        this.date = date;
        return date;
    }

    /**
     * Get the list of replies to this comment.
     *
     * @return ArrayList containing all the replies to this comment.
     */
    public ArrayList<Comment> getReplies() {
        return replies;
    }

    /**
     * Add a reply to this comment.
     *
     * @param reply The reply to be added.
     * @return The added reply.
     */
    public Comment addReply(Comment reply) {
        replies.add(reply);
        return reply;
    }

    /**
     * Delete a reply from this comment.
     *
     * @param reply The reply to be removed.
     * @return true if the reply was removed successfully, false otherwise.
     */
    public boolean deleteReply(Comment reply) {
        return replies.remove(reply);
    }
}
