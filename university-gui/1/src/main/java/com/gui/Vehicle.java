package com.gui;

import java.time.LocalDate;

public abstract class Vehicle {

    private final Producer producer;
    private final LocalDate manufactureDate;

    private final boolean isLowFloor;
    private final boolean isArticulated;

    long mileage;
    int age;

    Vehicle(Producer producer, LocalDate manufactureDate, boolean isLowFloor, boolean isArticulated, long mileage)
            throws Exception
    {
        if(manufactureDate.isAfter(LocalDate.now()))
            throw new Exception("Manufacutre date is after today");
        this.producer = producer;
        this.manufactureDate = manufactureDate;
        this.isLowFloor = isLowFloor;
        this.isArticulated = isArticulated;
        this.mileage = mileage;
        this.age = LocalDate.now().getYear() - manufactureDate.getYear();
    }

    public Producer getProducer() {
        return producer;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public boolean isLowFloor() {
        return isLowFloor;
    }

    public boolean isArticulated() {
        return isArticulated;
    }

    public long getMileage() {
        return mileage;
    }

    public int getAge() {
        return age;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
