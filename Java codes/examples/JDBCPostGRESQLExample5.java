package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.*;
 
public class JDBCPostGRESQLExample5{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
        String mySQL = "CREATE TABLE PINFO ( " +
                		" ID INT PRIMARY KEY     NOT NULL," +
                		" NAME           VARCHAR(25)    NOT NULL, " +
                		" AGE            INT     NOT NULL, " +
                		" ADDRESS        CHAR(50))";	
        
	 	try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    Statement stmt = conn.createStatement();
	 			 ){
	 		
	 		if( stmt.executeUpdate(mySQL)==0) {
	 			System.out.println("Table created successfully");
	 		}else {
	 			
	 			System.out.println("Table creation fails");
	 		
	 		}
 	
       }catch (SQLException e) {
    		 System.out.println(e.getMessage());
       }
    }
}

