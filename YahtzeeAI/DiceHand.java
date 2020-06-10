package YahtzeeAI;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * class DiceHand takes in a number of dice, number of sides per
 * die, and on rollHand, a value is gathered for each die.  It is
 * recommended that an extension class is made for hands used in
 * other games.
 */
public class DiceHand {
    ArrayList<DieObject> diceHand;

    public DiceHand(int numDice, int dieSides){
        this.diceHand = new ArrayList<>();
        this.populateHand(numDice, dieSides);
        this.rollHand();
    }

    public DiceHand(int numDice){
        this(numDice, 6);
    }

    public DiceHand(){
        this(5, 6);
    }
    
    private void populateHand(int numDice, int dieSides) {
        for(int i = 0; i < numDice; i++){
            this.diceHand.add(new DieObject(dieSides));
        }
    }
    public int getNumDice(){
        return this.diceHand.size();
    }

    public void rollHand(){
        for(DieObject dieObject: this.getDiceHand()){
            dieObject.roll();
        }
        this.sortHand();
    }

    /**
     * Comparator allows sorting die by integer values when called.
     */
    private final Comparator<DieObject> withDiceValueComparator = Comparator.comparingInt(DieObject::getRollValue);

    /**
     * Sorts a hand of die in ascending order using comparator.
     */
    private void sortHand(){
        this.getDiceHand().sort(withDiceValueComparator);
    }

    private ArrayList<DieObject> getDiceHand(){
        return this.diceHand;
    }

    @Override
    public String toString(){
        StringBuilder handOut = new StringBuilder();
        for (DieObject dieObject : this.getDiceHand()) {
            handOut.append(dieObject.getRollValue()).append(" ");
        }
        return handOut.toString();
    }
}
