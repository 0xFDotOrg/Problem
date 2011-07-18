package org.zeroxf.Problem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.entity.Player;
import org.zeroxf.Problem.Problem.Status;

/**
 *
 * @author necavi
 * @author gothroach
 */

public class ProblemSQL {
    private static Problem plugin;
    
    public ProblemSQL(Problem problem)
    {
        ProblemSQL.plugin = problem;
    }
    
    protected ProblemComment[] loadComments(int ticketId)
    {
        
    }
    
    protected ProblemTicket loadTicket(int ticketId)
    {
        
    }
    
    protected ProblemTicket[] loadOpenTickets(int since)
    {
        
    }
    protected ProblemTicket[] loadOpenTickets(int since, int num)
    {
        
    }
    
    protected ProblemTicket findTicket(String searchterm, Status status)
    {
        
    }
    protected ProblemTicket[] findTicket(String searchterm, Status status, int num)
    {
        
    }
    
    protected ProblemTicket[] findTicketsByOwner(String owner, Status status)
    {
        
    }
    protected ProblemTicket[] findTicketsByOwner(String owner, Status status, int num)
    {
        
    }
   
    protected ProblemTicket[] findTicketsByAssignee(String assignee, Status status)
    {
        
    }
    protected ProblemTicket[] findTicketsByAssignee(String assignee, Status status, int num)
    {
        
    }
    
    protected boolean addTicket(Player player, String message)
    {
        
    }
    
    protected boolean addComment(ProblemTicket ticket, Player player, String message)
    {
        
    }
    
    protected boolean updateStatus(ProblemTicket ticket, Player player, Status status)
    {
        
    }
}
