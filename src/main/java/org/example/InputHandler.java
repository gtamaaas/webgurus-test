package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {

    public Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public void handleFloorChange() {
        System.out.println("Change floor from 0 to 6: ");
        int destinationFloor = scanner.nextInt();
        while(destinationFloor < 0 || destinationFloor > 6) {
            System.out.println("Invalid floor, please choose another");
            destinationFloor = scanner.nextInt();
        }
        System.out.println("Changed floor to " + destinationFloor);
    }

    public String handleUpOrDownDirection() {
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
        else
            System.out.println("Going" + destination + "...");
        return destination;
    }
}
