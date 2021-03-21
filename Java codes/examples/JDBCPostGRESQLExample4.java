package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.*;
 
public class JDBCPostGRESQLExample4{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
	 	String mySQL = "SELECT id, name, dept_name, salary FROM instructor";
	 
	 	try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    Statement stmt = conn.createStatement();
	 			ResultSet rset = stmt.executeQuery(mySQL); ){
	 		
	        while (rset.next()) {
	        	/* Retrieves the value of the designated column in the current row 
	        	   of this ResultSet object as a String in the Java programming language.
	        	*/
	            System.out.println("ID :"+ rset.getString("id") + "\t"
	                    + "Name :"+ rset.getString(2) + "\t\t"
	                    + "Dept_name :"+ rset.getString("dept_name") + "\t\t"
	                    + "Salary :"+ rset.getString("salary"));
	 
	        }
	 		 	
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
    }
}

