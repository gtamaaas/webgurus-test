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

    public Lift getLiftCloserToFloor() {
        int distanceFromA = Math.abs(A.location - this.level);
        int distanceFromB = Math.abs(B.location - this.level);
        if(distanceFromA < distanceFromB) {
            System.out.println("Distance from A " + distanceFromA);
            return A;
        }
        else if ( distanceFromA > distanceFromB) {
            System.out.println("Distance from B " + distanceFromB);
            return B;
        }
        else if (A.location >= B.location) {
            System.out.println("Distance from B " + distanceFromB);
            return B;
        }
        else {
            System.out.println("Distance from A " + distanceFromB);
            return A;
        }

    }


    public boolean liftIsHere() {
        return (A.location == level || B.location == level);
    }

    //called with liftIsHere
    public Lift chooseLift() {
        if(A.location == level)
            return A;
        if(B.location == level)
            return B;
        return null;
    }

    public void calLLift() {
        if(liftIsHere())
            System.out.println("lift is already here");
        else {
            System.out.println("Lift is called from " + level);
            Lift lift = getLiftCloserToFloor();
            lift.liftTravel(level);

        }
    }

    @Override
    public String toString() {
        return "Floor{" +
                "level=" + level +
                ", up=" + up +
                ", down=" + down +
                '}';
    }
}
