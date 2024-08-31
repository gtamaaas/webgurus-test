package org.example;


public class Floor {

    public int level;

    public boolean up = false;

    public boolean down = false;

    public Lift A;
    public Lift B;


    public Floor(int level, Lift a, Lift b) {
        this.level = level;
        A = a;
        B = b;
    }

    // only calculates distance right now
    public void callLift() {
        int distanceFromA = Math.abs(A.location - this.level);
        int distanceFromB = Math.abs(B.location - this.level);
        if(distanceFromA < distanceFromB)
            System.out.println("Distance from A " + distanceFromA);
        else if ( distanceFromA > distanceFromB)
            System.out.println("Distance from B " + distanceFromB);
        else if (A.location >= B.location)
            System.out.println("Distance from B " + distanceFromB);
        else
            System.out.println("Distance from A " + distanceFromB);

    }

//    public void liftTransport(int destination) {
//        inputHandler.handleUpOrDownDirection();
//        callLift();
//    }

    @Override
    public String toString() {
        return "Floor{" +
                "level=" + level +
                ", up=" + up +
                ", down=" + down +
                '}';
    }
}
