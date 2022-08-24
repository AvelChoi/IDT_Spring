package com.example.hellojdbc;

import java.util.List;

public interface StudentDao {
    List<Student> selectAll();

    void insert(Student student);

}
