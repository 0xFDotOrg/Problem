package org.zeroxf.Problem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    protected ProblemTicket findTicket(String searchterm, String status)
    {
        
    }
    protected ProblemTicket[] findTicket(String searchterm, String status, int num)
    {
        
    }
    
    protected ProblemTicket[] findTicketsByOwner(String owner, String status)
    {
        
    }
    protected ProblemTicket[] findTicketsByOwner(String owner, String status, int num)
    {
        
    }
   
    protected ProblemTicket[] findTicketsByAssignee(String assignee, String status)
    {
        
    }
    protected ProblemTicket[] findTicketsByAssignee(String assignee, String status, int num)
    {
        
    } 
}
