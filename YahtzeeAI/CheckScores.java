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

    public String getOnesScore() {
        return String.valueOf(this.count(1));
    }
    public String getTwosScore() {
        return String.valueOf(2 * this.count(2));
    }
    public String getThreesScore() {
        return String.valueOf(3 * this.count(3));
    }
    public String getFoursScore() {
        return String.valueOf(4 * this.count(4));
    }
    public String getFivesScore() {
        return String.valueOf(5 * this.count(5));
    }
    public String getSixesScore() {
        return String.valueOf(6 * this.count(6));
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
