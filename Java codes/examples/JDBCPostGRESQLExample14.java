package com.cs425.postgresql;

/*
 * Display Metadata of Resultset 
 * 
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
 
/**
 * @author IBM/Tutorialspoint
 */
public class JDBCPostGRESQLExample14{
    static final String url = "jdbc:postgresql://localhost/university";
    static final String user = "postgres";
    static final String password = "1234";//"<add your password>";

    public static void main(String[] args) {
    	Savepoint savept = null ;
    	Connection conn = null;
    	Statement stmt =null;
        
    	try{
    		
    		conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
    		
    		//  Set auto commit as false.
    		conn.setAutoCommit(false);	    
		   //set a Savepoint

    		savept = conn.setSavepoint("Savepoint1");
		
    		String SQL = "INSERT INTO INSTRUCTOR " +
		                "VALUES ('22', 'Alice', 'English', 60000)";
    		stmt.executeUpdate(SQL); 
    		// Commit the transaction
    		conn.commit(); 
		
    		//Submit a malformed SQL statement that breaks
    		SQL = "INSERTED IN Employees " +
    				"VALUES ('2', 'Bob', 'Comp. Sci.', '90000')";
    		
    		stmt.executeUpdate(SQL);
    		// Commit the transaction
    		conn.commit();  
                    	
    	} catch (SQLException e) {
    		
    		System.out.println(e.getMessage());
    	    System.out.println("Rolling back data here....");
    	    try {
				conn.rollback(savept);
			} catch (SQLException e1) {
	    	    System.out.println("error back data here....");

				e1.printStackTrace();
			}
   	      
    	}
		// Release the savepoint
		try {
			conn.releaseSavepoint(savept);
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

    }
}

