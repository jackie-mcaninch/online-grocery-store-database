package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.*;
 
public class JDBCPostGRESQLExample7{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
        String mySQL = "SELECT id, name, dept_name, salary "
                		+ "FROM instructor "
                		+ "WHERE id = ?";

        String instructorID = "65931" ;
	 	try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    PreparedStatement pStmt = conn.prepareStatement(mySQL)){
	 		
	 		pStmt.setString(1, instructorID);
	 		
            ResultSet rs = pStmt.executeQuery();
            
            while (rs.next()) {
            	/* Retrieves the value of the designated column in the current row 
            	   of this ResultSet object as a String in the Java programming language.
            	*/
                System.out.println(rs.getString("id") + "\t"
                        + rs.getString("name") + "\t"
                        + rs.getString("dept_name") + "\t"
                        + rs.getString("salary"));
            }
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
    }
}

