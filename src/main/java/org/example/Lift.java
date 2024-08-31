package org.example;

public class Lift {
    public int location;

    StringBuilder template = new StringBuilder("0-1-2-3-4-5-6");
    public Lift(int location) {
        // todo
        // check value is correct
        this.location = location;
        template.setCharAt(location * 2, 'x');
    }

    public void positionDisplay(int currentPosition, int nextPosition) {
        System.out.println(template);
        template.setCharAt(currentPosition * 2, (char) (currentPosition + '0'));
        template.setCharAt(nextPosition * 2, 'x');
    }

    public void liftTravel(int destination) {
        System.out.println("Starting lift journey: ");
        if(location > destination) {
            while(location > destination) {
                positionDisplay(location, location - 1);
                --location;
            }
        }
        else {
            while (location < destination) {
                positionDisplay(location, location + 1);
                ++location;
            }
        }
        System.out.println(template);
        System.out.println("Lift has arrived");
    }

    @Override
    public String toString() {
        return template.toString();
    }
}
