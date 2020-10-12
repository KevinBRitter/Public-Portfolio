package YahtzeeAI;

import java.util.Collections;

public class CheckScores {
    private DiceHand hand;

    public void useDice(DiceHand currentHand) {
        this.hand = currentHand;
    }

    public String getHand() {
        return this.hand.toString();
    }

    public int getOnesScore() {
        return (this.count(1));
    }
    public int getTwosScore() {
        return (2 * this.count(2));
    }
    public int getThreesScore() {
        return (3 * this.count(3));
    }
    public int getFoursScore() {
        return (4 * this.count(4));
    }
    public int getFivesScore() {
        return (5 * this.count(5));
    }
    public int getSixesScore() {
        return (6 * this.count(6));
    }

    private int count(int j) {
        int counter = 0;
        for (int i = 0; i < this.hand.getNumDice(); i++){
            if (this.hand.getValue(i) == j){
                counter++;
            }
        }
        return counter;
    }
}
