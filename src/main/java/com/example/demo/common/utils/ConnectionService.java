package com.example.demo.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {

    public Connection openConnection(Connection conn) throws Exception {
        String url = "jdbc:mariadb://localhost:3306/testerp?characterEncoding=utf-8";
        String user = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, user, password);
        conn.setAutoCommit(false);
        System.out.println("==== Open Connection ====");
        return conn;
    }


    public void closeConnection(Connection conn) throws Exception {
        conn.close();
        System.out.println("==== Close Connection ====");
    }
}
