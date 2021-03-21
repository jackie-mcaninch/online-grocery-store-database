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
 * @author Yousef
 */
public class JDBCPostGRESQLExample10{
 
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
    			Connection conn = connect();
    	    	DatabaseMetaData dbmd = conn.getMetaData();
   	    	
    	    	System.out.println("Driver Name: "+dbmd.getDriverName());  
    	    	System.out.println("Driver Version: "+dbmd.getDriverVersion());  
    	    	System.out.println("UserName: "+dbmd.getUserName());  
    	    	System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
    	    	System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
    	    	
    	    	// Displays total number of tables 
    	    	String table[]={"TABLE"};  
                ResultSet rs=dbmd.getTables(null,null,null,table);  
    	    			  
    	    	while(rs.next()){  
    	    		System.out.println(rs.getString(3));  
    	     	}  

    	    	/*  
    	    	 * getColumns() method 
    	    	 *  method retrieves the description of the columns of a table. It accepts 4 parameters 
    	    	 *  
    	    	 */
    	    	// Display columns for instructor
    	    	ResultSet rs1 = dbmd.getColumns(null,null, "instructor", null);
    	    	System.out.println("Columns of instructor Table");
    	    	while(rs1.next()) {
    	    		System.out.println(rs1.getString("COLUMN_NAME") + "\t"+
    	    						rs1.getString("TYPE_NAME"));
    	    	}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JDBCPostGRESQLExample10 myObject = new JDBCPostGRESQLExample10();
        myObject.displyDBMetadata();
    }
}

