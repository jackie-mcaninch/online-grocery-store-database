package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.*;
 
public class JDBCPostGRESQLExample3{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
	 	String mySQL = "SELECT count(*) FROM instructor";
        int count = 0;
	 
	 	try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    Statement stmt = conn.createStatement();
	 			ResultSet rset = stmt.executeQuery(mySQL); ){
	 		
            /* Moves the cursor forward one row from its current position. 
   	     		A ResultSet cursor is initially positioned before the first row;
   	     		the first call to the method next makes the first row the current row; 
   	     		the second call makes the second row the current row, and so on. 
             	*/
	 		
	 		rset.next(); 
	 		/* Retrieves the value of the designated column in the current row of this 
   	      	   ResultSet object as an int in the Java programming language.
	 		 */
	 		count = rset.getInt(1);
       
	 		System.out.println("# of Instructors : "+count);
	 		 	
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
    }
}

