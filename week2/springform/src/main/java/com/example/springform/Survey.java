package com.example.springform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    private int surveyIdx;
    private String title;
    private int type;


}
