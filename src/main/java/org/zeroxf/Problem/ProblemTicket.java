package org.zeroxf.Problem;

/**
 * Data class to hold a problem ticket and related information.
 * 
 * @author necavi
 * @author gothroach
 */
public class ProblemTicket {
    private int ticketId;
    private String owner;
    private String assignee;
    private int time;
    private String status;
    private ProblemComment[] comments;
    
    public ProblemTicket()
    {
        this.ticketId = -1;
        this.owner = null;
        this.assignee = null;
        this.time = -1;
        this.status = null;
        this.comments = new ProblemComment[32];
    }
    
    public ProblemTicket(int ticketId, String owner, String assignee, int time, String status, ProblemComment[] comments)
    {
        this.setTicketId(ticketId);
        this.setOwner(owner);
        this.setAssignee(assignee);
        this.setTime(time);
        this.setStatus(status);
        this.comments = new ProblemComment[32];
        this.setComments(comments);
    }
    
    protected int getTicketId()
    {
        return this.ticketId;
    }
    protected final void setTicketId(int ticketId)
    {
        this.ticketId = ticketId;
    }
    
    protected String getOwner()
    {
        return this.owner;
    }
    protected final void setOwner(String owner)
    {
        this.owner = owner;
    }
    
    protected String getAssignee()
    {
        return this.assignee;
    }
    protected final void setAssignee(String assignee)
    {
        this.assignee = assignee;
    }
    
    protected int getTime()
    {
        return this.time;
    }
    protected final void setTime(int time)
    {
        this.time = time;
    }
    
    protected String getStatus()
    {
        return this.status;
    }
    protected final void setStatus(String status)
    {
        this.status = status;
    }
    
    protected ProblemComment[] getComments()
    {
        return this.comments;
    }
    protected ProblemComment getComment(int i)
    {
        if (i < this.comments.length && i >= 0)
            return this.comments[i];
        else
            return null;
    }
    protected final void setComments(ProblemComment[] comments)
    {
        this.comments = comments;
    }
    protected final void setComment(ProblemComment comment, int i)
    {
        if (i >=0)
            this.comments[i] = comment;
    }
}
