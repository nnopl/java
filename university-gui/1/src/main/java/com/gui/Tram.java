package com.gui;

import java.time.LocalDate;

public class Tram extends Vehicle{
    public Tram(Producer producer, LocalDate manufactureDate, boolean isLowFloor, boolean isArticulated, Long mileage) throws Exception {
        super(producer, manufactureDate, isLowFloor, isArticulated, mileage);
    }
}
