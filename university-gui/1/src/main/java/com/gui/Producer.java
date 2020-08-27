package com.gui;

import java.time.LocalDate;

public class Producer {

    //example fields
    private final String name;
    private final LocalDate establishDate;

    public Producer(String name, LocalDate establishDate){
        this.name = name;
        this.establishDate = establishDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getEstablishDate() {
        return establishDate;
    }
}
