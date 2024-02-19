package com.junit.testing.junit5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietPlan {
    private int calories;
    private int protein;
    private int fat;
    private int carbohydrate;
}
