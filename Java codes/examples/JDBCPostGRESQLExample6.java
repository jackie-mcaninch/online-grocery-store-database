package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.*;
 
public class JDBCPostGRESQLExample6{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
        String mySQL = "INSERT INTO PINFO (ID,NAME,AGE,ADDRESS) "
		 		+ "VALUES (1, 'Alice', 18, 'Sacramento, California' ); " +
		 		"INSERT INTO PINFO (ID,NAME,AGE,ADDRESS) "
		 		+ "VALUES (2, 'Bob', 60, 'Atlanta, Georgia'); " +
		 		"INSERT INTO PINFO (ID,NAME,AGE,ADDRESS) "
    		 	+ "VALUES (3, 'Eve', 27, 'Chicago, IL' );";
        
	 	try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    Statement stmt = conn.createStatement();){
	 		
	 		conn.setAutoCommit(false);
	        System.out.println("Opened database successfully");

	        stmt.executeUpdate(mySQL);

	         conn.commit();

       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
	 	
		System.out.println("Records created successfully");
    }
}

