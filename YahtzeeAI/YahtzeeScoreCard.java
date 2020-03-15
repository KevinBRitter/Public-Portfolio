package YahtzeeAI;

import java.util.ArrayList;

/**
 * class Yahtzee Score Card creates a series of dice hands each
 * representing a single round in a game.  Each round is played by
 * an agent for up to three turns, or decisions for scoring.  These
 * follow the standard Yahtzee rule book.  At each step the agent is
 * given a list of the current state of the game for evaluation and
 * decision making.
 */
public class YahtzeeScoreCard {
    ArrayList<DiceHand> gameHands;

    /**
     * default constructor makes a new games worth of rounds
     * and calls the populate game hands method
     */
    public YahtzeeScoreCard(){
        this.gameHands = new ArrayList<>();
        this.populateGameHands();
    }

    /**
     * populate game hand method fills the rounds with new hands
     */
    private void populateGameHands(){
        for(int i = 0; i < 13; i++){
            this.gameHands.add(new DiceHand());
        }
    }

    /**
     * @return String of printable lines showing all the hands as they are
     */
    public String toString(){
        StringBuilder tempString = new StringBuilder();
        for(int i = 0; i < this.gameHands.size(); i++){
            tempString.append("Hand: ").append(i + 1).append(", ").append(this.gameHands.get(i)).append("\n");
        }
        return tempString.toString();
    }
}
