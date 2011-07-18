package org.zeroxf.Problem;

import org.bukkit.Location;

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
    private Location location;
    
    /**
     * Default constructor, creates an empty instance.
     */
    public ProblemComment()
    {
        this.name = null;
        this.time = -1;
        this.comment = null;
        this.location = null;
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
     * 
     * @param location  
     * The location at which the comment was submitted.
     */
    public ProblemComment(String name, int time, String comment, Location location)
    {
        this.setName(name);
        this.setTime(time);
        this.setComment(comment);
        this.setLocation(location);
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
    
    protected Location getLocation()
    {
        return this.location;
    }
    protected final void setLocation(Location location)
    {
        this.location = location;
    }
}
