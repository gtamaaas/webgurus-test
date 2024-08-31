package org.example;

// with 7 storeys (indexed 0-6)

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Lift A = new Lift(0);
        Lift B = new Lift(6);
        ArrayList<Floor> listOfFloors = new ArrayList<>();

        for (int i = 0; i <= 6; ++i) {
            Floor floor = new Floor(i, A, B);
            listOfFloors.add(floor);

        }
        Block block = new Block(listOfFloors);
        block.start();
    }
}