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
public class JDBCPostGRESQLExample11{
 
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
    		    //Retrieving the meta data object
    	    	DatabaseMetaData dbmd = conn.getMetaData();
    	        //Retrieving the columns in the database
    	    	/*  
    	    	 * getColumns() method 
    	    	 *  method retrieves the description of the columns of a table. It accepts 4 parameters 
    	    	 *  
    	    	 */
    	    	// Display columns for instructor
    	    	ResultSet rs = dbmd.getColumns(null,null, "instructor", "%");
    	    	System.out.println("Columns of instructor Table");
	            System.out.println("-------------------------");

    	    	while(rs.next()) {
    	            System.out.print("Column name and size: "+rs.getString("COLUMN_NAME"));
    	            System.out.print("("+rs.getInt("COLUMN_SIZE")+")");
    	            System.out.println(" ");
    	            System.out.println("Ordinal position: "+rs.getInt("ORDINAL_POSITION"));
    	            System.out.println("Catalog: "+rs.getString("TABLE_CAT"));
    	            System.out.println("Data type (integer value): "+rs.getInt("DATA_TYPE"));
    	            System.out.println("Data type name: "+rs.getString("TYPE_NAME"));
    	    
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
        JDBCPostGRESQLExample11 myObject = new JDBCPostGRESQLExample11();
        myObject.displyDBMetadata();
    }
}

