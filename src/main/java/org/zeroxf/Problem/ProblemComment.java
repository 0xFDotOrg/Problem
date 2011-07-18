package org.zeroxf.Problem;

/**
 * Data class to hold a comment relating to a problem ticket.
 * 
 * @author necavi
 * @author gothroach
*/
public class ProblemComment {
    private String name;
    private int time;
    private String comment;
    
    /**
     * Default constructor, creates an empty instance.
     */
    public ProblemComment()
    {
        this.name = null;
        this.time = -1;
        this.comment = null;
    }
    
    /**
     * Shortcut constructor to fill out the instance.
     * 
     * @param name
     * The name of the commenter.
     * 
     * @param time
     * The time of the comment.
     * 
     * @param comment
     * The body of the comment.
     */
    public ProblemComment(String name, int time, String comment)
    {
        this.setName(name);
        this.setTime(time);
        this.setComment(comment);
    }
    
    protected String getName()
    {
        return this.name;
    }
    protected final void setName(String name)
    {
        this.name = name;
    }
    
    protected int getTime()
    {
        return this.time;
    }
    protected final void setTime(int time)
    {
        this.time = time;
    }
    
    protected String getComment()
    {
        return this.comment;
    }
    protected final void setComment(String comment)
    {
        this.comment = comment;
    }
    
}
