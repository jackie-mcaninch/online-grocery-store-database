package com.cs425.postgresql;

/*
 * Display Metadata of Resultset 
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * @author Yousef
 */
public class JDBCPostGRESQLExample9{
 
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
     * Display the names and types of all columns of a result set
     *
     * @param rs
     */
    public void displyMetadata(String SQL) {

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
               	       	ResultSetMetaData rsmd = rs.getMetaData();
        	     	    for(int i = 1; i <= rsmd.getColumnCount(); i++) {
        	     	    		System.out.print(rsmd.getColumnName(i)+":\t");
        	     	       		System.out.println(rsmd.getColumnTypeName(i));

        	     	    }
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JDBCPostGRESQLExample9 myObject = new JDBCPostGRESQLExample9();
        String SQL = "SELECT * From instructor";
        myObject.displyMetadata(SQL);
    }
}

