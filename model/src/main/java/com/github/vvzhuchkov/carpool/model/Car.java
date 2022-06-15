package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;

public class Car implements Serializable {
    private int id;
    private String regNumber;
    private CarBrand brand;
    private String model;
    private double maxLoad;

}
