package com.example.hellojdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private int id;
    private String dept;

    public Student(int id, String name, String dept) {
    }
}
