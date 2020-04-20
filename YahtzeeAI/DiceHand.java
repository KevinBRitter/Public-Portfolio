package YahtzeeAI;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * class DiceHand takes in a number of dice, number of sides per
 * die, and on roll, a value is gathered for each die.  It is recommended
 * that an extension class is made for hands used in other games.
 */
public class DiceHand {
    ArrayList<DieObject> diceHand;

    /**
     * 2 param constructor instantiates the diceHand Array List
     * calls the populateHand method to build a new hand
     * @param numDice, takes the number of die objects required for the hand.
     * @param dieSides, takes the number of sides for all dice in the hand.
     */
    public DiceHand(int numDice, int dieSides){
        this.diceHand = new ArrayList<>();
        this.populateHand(numDice, dieSides);
        this.rollHand();
    }

    /**
     * one param constructor passes
     * @param numDice and default value to the hand through
     * the main constructor
     */
    public DiceHand(int numDice){
        this(numDice, 6);
    }

    /**
     * default constructor passes default values to the hand through
     * the main constructor
     */
    public DiceHand(){
        this(5, 6);
    }

    /**
     * populates a hand with die to roll for scores
     * @param numDice, takes in the number of dice for the hand object
     * @param dieSides, takes in the number of sides per die
     */
    private void populateHand(int numDice, int dieSides) {
        for(int i = 0; i < numDice; i++){
            this.diceHand.add(new DieObject(dieSides));
        }
    }

    /**
     * rolls each die in the hand for a new random value
     */
    public void rollHand(){
        for(DieObject dieObject: this.getDiceHand()){
            dieObject.roll();
        }
        this.sortHand();
    }

    // TODO: sort the dice by value smallest to largest
    private final Comparator<DieObject> compareByRoll = Comparator.comparingInt(DieObject::getRoll);

    private void sortHand(){
        this.getDiceHand().sort(compareByRoll);
    }

    /**
     * @return Array List of die objects: diceHand
     */
    private ArrayList<DieObject> getDiceHand(){
        return this.diceHand;
    }

    /**
     * @return a string representation of the dice hand's current
     * die values
     */
    @Override
    public String toString(){
        StringBuilder handOut = new StringBuilder();
        handOut.append(this.getDiceHand().size()).append(" Dice hand: ");
        for (DieObject dieObject : this.getDiceHand()) {
            handOut.append(dieObject.getRoll()).append(" ");
        }
        return handOut.toString();
    }
}
