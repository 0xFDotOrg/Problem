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
    
}
