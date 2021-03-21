package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class JDBCPostGRESQLExample1{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
    	 try (Connection conn = DriverManager.getConnection(url, user, password)){
    		 System.out.println("Connected to the PostgreSQL server successfully."); 
    		 	 
    	 }catch (SQLException e) {
    		 System.out.println(e.getMessage());
    	}
    }
}

