package YahtzeeAI;

import java.util.Random;

/**
 * class DieObject takes in a number of sides and randomly returns,
 * on roll, a value in the range between 1 and the number of sides.
 */
// TODO docs made in form of */ click on "Random" and hold ctrl-q
public class DieObject {
    private int numSides;
    private int rollValue;
    private Random randNum;

    /**
     * instantiates the random number variable
     * @param numSides, takes an integer value and if greater than
     *                  zero passes this value to the setSides method
     */
    public DieObject(int numSides){
        this.randNum = new Random();
        if(numSides > 0){
            this.setSides(numSides);
        }
        else{
            this.setSides(6);
        }
    }

    /**
     * default constructor passes a value of 6 to the die through
     * the other constructor
     */
    public DieObject(){ this(6); }

    /**
     * @param numSides, takes an integer value and stores this value
     *                  as the die's current number of sides
     */
    private void setSides(int numSides) {
        this.numSides = numSides;
    }

    /**
     * rolls a new random integer between 1 and the number of sides
     * passes the result to the setRollValue method
     */
    public void roll() {
        this.setRollValue(this.randNum.nextInt(this.getNumSides()) + 1);
    }

    /**
     * @param setValue, stores a new value as the die's current value
     */
    private void setRollValue(int setValue){
        this.rollValue = setValue;
    }

    /**
     * @return an integer, the die's number of sides
     */
    private int getNumSides() {
        return this.numSides;
    }

    /**
     * @return an integer, the die's current value
     */
    public int getRoll() {
        return this.rollValue;
    }

    /**
     * @return a string representation of the die's current value
     */
    @Override
    public String toString(){
        return this.getNumSides() + " sided die, rolled: " + this.getRoll();
    }

}
