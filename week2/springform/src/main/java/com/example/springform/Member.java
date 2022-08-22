package com.example.springform;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @NotNull
    private String name;

    @NotNull
    @Min(value=10)
    private int age;

    @NotNull
    @Email(message = "잘못된 email 양식입니다.")
    private String email;

}
