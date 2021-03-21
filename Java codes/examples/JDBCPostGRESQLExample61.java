package com.cs425.postgresql;

/*
 * Connected to the PostgreSQL server
 * 
 */


//Import required packages

import java.sql.*;
 
public class JDBCPostGRESQLExample61{


    public static void main(String[] args) {
    	 
        final String url = "jdbc:postgresql://localhost/university";
        final String user = "postgres";
        final String password = "1234";//"<add your password>";
    	
	 	String mySQL = "SELECT * "+
	 					"FROM PINFO "+
	 					"ORDER BY NAME";
   	 	
	 	try (Connection conn = DriverManager.getConnection(url, user, password);
	 		    Statement stmt = conn.createStatement();
	 			ResultSet rset = stmt.executeQuery(mySQL); ){
	 		
 
	 		while(rset.next()) {
	 			System.out.println( "ID: "  + rset.getString(1) 
	 					+ "\t NAME: "  + rset.getString(2)
	 					+ "\t AGE: "  + rset.getString(3) 
	 					+ "\t ADDRESS: "  + rset.getString(4));	 		
	 			}
	 		 	
     
    	 }catch (SQLException e) {
    		 System.out.println(e.getMessage());
    	}
    }
}

