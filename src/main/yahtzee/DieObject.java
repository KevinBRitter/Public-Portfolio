package main.yahtzee;

import java.util.Random;

/**
 * class DieObject takes in a number of sides and randomly returns,
 * on roll, a value in the range between 1 and the number of sides.
 * The default number of sides is 6.
 */
public class DieObject {
    private final int numSides;
    private int rollValue;
    private final Random randNum;

    public DieObject(int numSides){
        this.randNum = new Random();
        int minNumSides = 2;
        int defaultDieSides = 6;
        this.numSides = numSides < minNumSides ? defaultDieSides : numSides;
        this.roll();
    }

    public DieObject(){ this(6); }

    /**
     * rolls a new random integer between 1 and the number of sides
     */
    public void roll() {
        this.rollValue = this.randNum.nextInt(this.getNumSides()) + 1;
    }

    private int getNumSides() {
        return this.numSides;
    }

    public int getRollValue() {
        return this.rollValue;
    }

    @Override
    public String toString(){
        return String.valueOf(this.getRollValue());
    }
}
