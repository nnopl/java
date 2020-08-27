package com.gui;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bus extends Vehicle {
    private final BigDecimal engineCapacity;
    private final FuelType fuelType;

    public Bus(Producer producer, LocalDate manufactureDate, boolean isLowFloor, boolean isArticulated, Long mileage,
               FuelType fuelType, BigDecimal engineCapacity) throws Exception {
        super(producer, manufactureDate, isLowFloor, isArticulated, mileage);
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
    }

    public BigDecimal getEngineCapacity() {
        return engineCapacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
