package YahtzeeAI;

import java.util.Random;

/**
 * class DieObject takes in a number of sides and randomly returns,
 * on roll, a value in the range between 1 and the number of sides.
 * The default number of sides is 6.
 */
public class DieObject {
    private int numSides;
    private int rollValue;
    private final Random randNum;

    public DieObject(int numSides){
        this.randNum = new Random();
        this.setSides(numSides);
        this.roll();
    }

    public DieObject(){ this(6); }

    private void setSides(int numSides) {
        int defaultSize = 6;
        if(numSides < 1){
            this.numSides = defaultSize;
        }
        else{
            this.numSides = numSides;
        }
    }

    /**
     * rolls a new random integer between 1 and the number of sides
     * passes the result to the setRollValue method.
     */
    public void roll() {
        this.setRollValue(this.randNum.nextInt(this.getNumSides()) + 1);
    }

    private void setRollValue(int setValue){
        this.rollValue = setValue;
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
