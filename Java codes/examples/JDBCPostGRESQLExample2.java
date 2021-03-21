package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.*;
 
public class JDBCPostGRESQLExample2{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
	 	String mySQL = "SELECT dept_name, avg(salary) "+
	 					"FROM INSTRUCTOR "+
	 					"GROUP BY dept_name";
	 	
	 	try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    Statement stmt = conn.createStatement();
	 			ResultSet rset = stmt.executeQuery(mySQL); ){
	 		
 			System.out.println( "dept_name"  +"\t\t" + "budget\n" );
 
	 		while(rset.next()) {
	 			System.out.println(rset.getString("dept_name") +"\t\t" + rset.getString(2));
	 		}
	 		 	
     
    	 }catch (SQLException e) {
    		 System.out.println(e.getMessage());
    	}
    }
}

