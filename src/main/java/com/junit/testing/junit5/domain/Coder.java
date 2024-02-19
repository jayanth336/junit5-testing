package com.junit.testing.junit5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coder {
    private double height;
    private double weight;
    private int age;
    private Gender gender;

    public Coder(double height, double weight) {
        super();
        this.height = height;
        this.weight = weight;
    }
}
