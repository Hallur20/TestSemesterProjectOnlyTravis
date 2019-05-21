/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zaeem
 */
public class Conn {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/LESdb?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //  Database credentials    
    static final String USER = "root";
    static final String PASS = "root";
    private static Connection conn = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        if (conn == null) { //STEP 1: Register JDBC driver            
            Class.forName("com.mysql.cj.jdbc.Driver");
        }

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        //STEP 2: Open a connection
        return conn;
    }

    public void close() throws SQLException {
        conn.close();
    }
}
