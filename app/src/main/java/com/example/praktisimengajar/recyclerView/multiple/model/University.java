package com.example.praktisimengajar.recyclerView.multiple.model;

public class University {

    int id;
    String name;
    int majorsCount;

    public University(int id, String name, int majorsCount) {
        this.id = id;
        this.name = name;
        this.majorsCount = majorsCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMajorsCount() {
        return majorsCount;
    }
}
