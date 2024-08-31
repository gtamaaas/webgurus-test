package org.example;

public class Lift {
    public int location;

    public Lift(int location) {
        // todo
        // check value is correct
        this.location = location;
    }

    public void printLocation() {
        System.out.println("Lift is currently at " + location);
    }
}
