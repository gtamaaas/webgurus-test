package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {

    public Scanner scanner;

    public Block block;

    public InputHandler(Block block) {
        scanner = new Scanner(System.in);
        this.block = block;
    }

    // todo
    // solve non integer input
    public void handleFloorChange() {
        System.out.println("Change floor from 0 to 6: ");
        int destinationFloor = scanner.nextInt();
        while(destinationFloor < 0 || destinationFloor > 6) {
            System.out.println("Invalid floor, please choose another");
            destinationFloor = scanner.nextInt();
        }
        scanner.nextLine();
        block.setActiveFloor(destinationFloor);
        System.out.println("You are now on floor " + destinationFloor);
    }

    public void handleUpOrDownDirection() {
        System.out.println("Which way are you going? Up/down (u/d) or quit (q): ");
        String[] validDestinations = {"up", "down", "u", "d", "quit", "q"};
        String destination = scanner.nextLine();
        while(!Arrays.asList(validDestinations).contains(destination)) {
            System.out.println(destination + " is not valid, please try again!");
            destination = scanner.nextLine();
        }
        if (destination.equals("u"))
            System.out.println("Going up...");
        else if (destination.equals("d"))
            System.out.println("Going down...");
        else if (destination.equals("q"))
            return;
        else
            System.out.println("Going" + destination + "...");
        block.activeFloor.calLLift();
    }

    public void getIntoLift() {
        if(block.activeFloor.liftIsHere()) {
            System.out.println("You are inside the lift. Where do you want to go? (0-6)");
            int destinationFloor = scanner.nextInt();
            while (destinationFloor < 0 || destinationFloor > 6) {
                System.out.println("Invalid floor, please choose another");
                destinationFloor = scanner.nextInt();
            }
            scanner.nextLine();
            block.activeFloor.chooseLift().liftTravel(destinationFloor);
            block.activeFloor.level = destinationFloor;

        }
        else {
            System.out.println("Can't get into lift it is not here!");
        }

    }

    public boolean handleUserAction() {
        String userAction = " ";
            System.out.println("What is your action? Change floor (cf), call lift (cl), get into lift (gi), get position (gp), or quit (q)");
            userAction = scanner.nextLine();
            switch (userAction) {
                case "cf":
                    handleFloorChange();
                    break;
                case "cl":
                    handleUpOrDownDirection();
                    break;
                case "gi":
                    getIntoLift();
                    break;
                case "q":
                    return true;
                    // todo
                case "gp":
                    System.out.println("You are on " + block.activeFloor.level);
                    break;
                default:
                    System.out.println("Invalid operation, please try again");
            }
        return false;
    }
}
