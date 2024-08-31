package org.example;

public class Lift {
    public int location;

    public boolean up = false;

    public boolean down = false;
    StringBuilder template = new StringBuilder("0-1-2-3-4-5-6");
    public Lift(int location) {
        // todo
        // check value is correct
        this.location = location;
        template.setCharAt(location * 2, 'x');
    }

    public void positionDisplay(int currentPosition, int nextPosition) {
        System.out.println(template);
        if(up)
            System.out.println(">>>>>>>>>>>>>");
        if(down)
            System.out.println("<<<<<<<<<<<<<");
        System.out.println();
        template.setCharAt(currentPosition * 2, (char) (currentPosition + '0'));
        template.setCharAt(nextPosition * 2, 'x');
    }

    public void liftTravel(int destination) {
        System.out.println("Starting lift journey: ");
        if(location > destination) {
            down = true;
            while(location > destination) {
                positionDisplay(location, location - 1);
                --location;
            }
        }
        else {
            up = true;
            while (location < destination) {
                positionDisplay(location, location + 1);
                ++location;
            }
        }
        down = false;
        up = false;
        System.out.println(template);
        System.out.println("Lift has arrived!");
    }

    @Override
    public String toString() {
        return template.toString();
    }

}
