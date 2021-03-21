package com.cs425.postgresql;

/*
 * Display Instructor information 
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPostGRESQLExample8{
 
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
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
    
    /**
     * Update instructor's name based on instructor's id
     *
     * @param id
     * @param name
     * @return the number of affected rows
     */
    
    public int updateName(String id, String name) {
        String SQL = "UPDATE instructor "
                + "SET name = ? "
                + "WHERE id = ?";
 
        int affectedrows = 0;
 
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
 
            pstmt.setString(1, name);
            pstmt.setString(2, id);
 
            affectedrows = pstmt.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Record(s) updated successfully");

        return affectedrows;
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JDBCPostGRESQLExample8 myObject = new JDBCPostGRESQLExample8();
        myObject.updateName("65931","SammynManny");
    }
}

