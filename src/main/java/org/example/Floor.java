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

    public void calLLift() {
        if(A.location == level || B.location == level) {
            System.out.println("Lift is already here");
        }
        else {
            System.out.println("Lift is called from " + level);
            Lift lift = getLiftCloserToFloor();
//            System.out.println("Lift arrived from" + lift.location);
//            lift.location = level;
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
