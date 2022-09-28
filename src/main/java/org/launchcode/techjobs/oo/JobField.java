package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private final int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

//    public JobField(String value) {
//        this();
//        this.value = value;
//    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}