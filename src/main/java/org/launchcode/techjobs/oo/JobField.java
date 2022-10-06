package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    //private int id;
    private final int id;
    private static int nextId = 1;
    private String value;


    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField job = (JobField) o;
        return getId() == job.getId();
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
