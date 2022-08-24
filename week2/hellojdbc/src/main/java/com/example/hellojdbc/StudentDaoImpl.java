package com.example.hellojdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

public class StudentDaoImpl implements StudentDao {

    Connection conn;
    Statement stmt;
    ResultSet rs;

    // 생성자에서 수행할 것이 있다
    public StudentDaoImpl() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:mem:inmemory", "sa", "");

        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE STUDENT(\n" + "ID NUMBER NOT NULL,\n" + "NAME VARCHAR(10) NOT NULL,\n" + "DEPT VARCHAR(20) NOT NULL,\n" + "PRIMARY KEY(ID)\n" + ");");

        stmt.close();
    }


    @Override
    public List<Student> selectAll() {

        ArrayList<Student> students = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM STUDENT");

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("dept")
                ));

//                String name = rs.getString("name");
//                String id = rs.getString("id");
//                String dept = rs.getString("dept");
//
//                System.out.println(name + id + dept);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void insert(Student student) {

    }
}
