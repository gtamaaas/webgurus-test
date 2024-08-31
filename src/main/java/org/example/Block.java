package org.example;

import java.util.List;

public class Block {

    public List<Floor> floors;

    public Floor activeFloor;
    public InputHandler inputHandler = new InputHandler(this);



    public Block(List<Floor> floors) {
        this.floors = floors;
        activeFloor = floors.get(0);
        System.out.println("Welcome to the lift simulation! You are currently at floor: " + activeFloor);
    }

    public void setActiveFloor(int level) {
        activeFloor = floors.get(level);
    }

    public void start() {
        boolean quit = false;
        while(!quit)
            quit = inputHandler.handleUserAction();
        System.out.println("Finished simulation.");
    }
}
