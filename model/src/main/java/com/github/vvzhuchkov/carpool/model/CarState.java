package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;

public class CarState implements Serializable {
    private int id;
    private String location;
    private String orderNumber;
    private CarStatus status;
}
