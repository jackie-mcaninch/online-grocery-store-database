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
import java.sql.Statement;
 
/**
 * @author Tutorialspoint
 */
public class JDBCPostGRESQLExample13{
 
    private final String url = "jdbc:postgresql://localhost/university";
    private final String user = "postgres";
    private final String password = "1234";//"<add your password>";
 
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
        	//Attempts to establish a connection to the given database URL
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
    
    /**
     * Finding database information in JDBC
     *
     * @param rs
     */
    public void displyDBMetadata() {
    	try{
    	        //Getting the connection
    			Connection conn = connect();
    		    //Retrieving the meta data object
    	    	DatabaseMetaData dbmd = conn.getMetaData();
    	        //Retrieving the columns in the database
    	    	/*  
    	    	 * getPrimaryKeys() method 
    	    	 *  
    	    	 */
    	    	ResultSet rs = dbmd.getPrimaryKeys("","", "instructor");

    	        //Printing the column name and size


    	    	while(rs.next()) {
    	            System.out.println("Table name: "+rs.getString("TABLE_NAME"));
    	            System.out.println("Column name: "+rs.getString("COLUMN_NAME"));
    	            System.out.println("Catalog name: "+rs.getString("TABLE_CAT"));
    	            System.out.println("Primary key sequence: "+rs.getString("KEY_SEQ"));
    	            System.out.println("Primary key name: "+rs.getString("PK_NAME"));
    	            System.out.println(" ");
    	    
    	            System.out.println("-------------------------"); 
    	    	}
    	    	
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JDBCPostGRESQLExample13 myObject = new JDBCPostGRESQLExample13();
        myObject.displyDBMetadata();
    }
}

