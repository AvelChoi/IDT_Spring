package com.example.hellojdbc;

import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");

        Connection con = DriverManager.getConnection("jdbc:h2:mem:inmemory", "sa", "");

        System.out.println("DB Connection completed");

        Statement stmt = con.createStatement();

        stmt.execute(
                "CREATE TABLE STUDENT(\n" +
                        "ID NUMBER NOT NULL, \n" +
                        "NAME VARCHAR(10) NOT NULL, \n" +
                        "DEPT VARCHAR(20) NOT NULL, \n" +
                        "PRIMARY KEY(ID)\n" +
                        ");"
        );

        System.out.println("INSERT");
        stmt.execute("INSERT INTO STUDENT VALUES(1, 'AAA', 'COM')");

        ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT");

        while (rs.next()) {
            String id = rs.getString("ID");
            String name = rs.getString("NAME");
            String dept = rs.getString("DEPT");

            System.out.println(id + name + dept);
        }

        System.out.println("조건 SELECT");
        rs = stmt.executeQuery("SELECT NAME, ID, DEPT FROM STUDENT WHERE ID='1'");

        while (rs.next()) {
            String id = rs.getString("ID");
            String name = rs.getString("NAME");
            String dept = rs.getString("DEPT");

            System.out.println(id + name + dept);
        }

    }
}
