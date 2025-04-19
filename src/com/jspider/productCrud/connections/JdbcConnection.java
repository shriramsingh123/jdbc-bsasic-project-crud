package com.jspider.productCrud.connections;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection(){

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m13","root","Jack@123");
        } catch (SQLException e) {
            throw new RuntimeException("SQLException - Facing problem while getting the connection");
        }

    }
}
