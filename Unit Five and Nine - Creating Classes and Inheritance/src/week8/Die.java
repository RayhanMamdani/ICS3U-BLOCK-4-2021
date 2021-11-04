package week8;

public class Die {
    //attributes define the state of an instance of the class at any particular time
    private int numSides;       //private means that they are only accessible (visible) inside the class
    private int topSide;

    public static final int DEFAULT_SIDES = 6;

    public Die() {
        numSides = DEFAULT_SIDES;
        roll();
    }

    public Die(int numSides) {
        this.numSides = numSides;
        roll();
    }

    public int getTopSide() {
        return topSide;
    }

    public void roll() {
        topSide = (int) (Math.random() * numSides)  + 1;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Die) 
            return this.topSide == ((Die) obj).topSide;
        return false;
    }

    public String toString() {
        return "" + topSide;
    }

}