package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Objects;

public class Car extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String regNumber;
    private String brand;
    private String model;
    private float maxLoad;
    private String status;//Available, busy, service ENUM?

    public Car(int id, String regNumber, String brand, String model, float maxLoad, String status) {
        super(id);
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.maxLoad = maxLoad;
        this.status = status;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(float maxLoad) {
        this.maxLoad = maxLoad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", regNumber='" + regNumber + '\'' +
                ", brand=" + brand +
                ", model='" + model + '\'' +
                ", maxLoad=" + maxLoad +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Float.compare(car.maxLoad, maxLoad) == 0 && regNumber.equals(car.regNumber) && brand == car.brand && model.equals(car.model) && status.equals(car.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, brand, model, maxLoad, status);
    }
}
