package com.example.springweb.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String userId;
    private String name;
    private int age;
    private boolean gender;
}
