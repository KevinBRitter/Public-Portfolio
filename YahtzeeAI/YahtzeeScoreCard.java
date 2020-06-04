package YahtzeeAI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * class YahtzeeScoreCard creates a series of dice hands each
 * representing a single round in a game.  Each round is played by
 * an agent for up to three turns, or scored if preferred.  These
 * follow the standard Yahtzee rule book.  At each step the agent is
 * given a list of the current state of the game for evaluation and
 * decision making.
 */
public class YahtzeeScoreCard {
    private ArrayList<DiceHand> gameHands;
    private HashMap<String, Integer> allScores;
    private int currentHand;
    final int totalHandsForCard = 13;
    private final String[] scoreNames = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "UpperPreTotal",
            "Bonus", "UpperTotal", "ThreeOfKind", "FourOfKind", "FullHouse", "SmallStraight", "LargeStraight",
            "YAHTZEE", "Chance", "BonusYahtzeeCount", "YahtzeeBonus", "LowerTotal", "GrandTotal"};

    public YahtzeeScoreCard(){
        this.gameHands = new ArrayList<>();
        this.allScores = new HashMap<>();
        this.populateGameHands();
        this.populateScores();
        this.setCurrentHand(0);
    }

    private void setCurrentHand(int handNumber) {
        this.currentHand = handNumber;
    }

    private void incrementCurrentHand(){
        this.currentHand++;
    }

    public int getCurrentHandNumber(){
        return this.currentHand;
    }

    private void populateGameHands(){
        for(int i = 0; i < this.totalHandsForCard; i++){
            this.gameHands.add(new DiceHand());
        }
    }

    /**
     * gameState returns an ArrayList of the current hand then all current scores.
     * It is used by an agent to make decisions.
     */
    public ArrayList<Integer> getGameState(){
        ArrayList<Integer> gameState = new ArrayList<>();
        for (DieObject die: gameHands.get(this.getCurrentHandNumber()).diceHand){
            gameState.add(die.getRollValue());
        }
        for(String name: this.scoreNames){
            gameState.add(this.allScores.get(name));
        }
        return gameState;
    }

    /**
     * All scores given initial value of -1 indicating they haven't been scored yet.
     */
    private void populateScores(){
        int defaultValue = -1;
        for(String name: this.scoreNames){
            this.allScores.put(name, defaultValue);
        }
    }

    private boolean updateScoreIfAllowed(String location, int newValue){
        if(this.allScores.get(location) == -1){
            this.allScores.replace(location, newValue);
            return true;
        }else{
            return false;
        }
    }

    public boolean setOnes(int newOnes){
        return this.updateScoreIfAllowed("Ones", newOnes);
    }
    private int getOnes(){
            return this.allScores.get("Ones");
    }
    public boolean setTwos(int newTwos){
        return this.updateScoreIfAllowed("Twos", newTwos);
    }
    private int getTwos(){
        return this.allScores.get("Twos");
    }
    public boolean setThrees(int newThrees){
        return this.updateScoreIfAllowed("Threes", newThrees);
    }
    private int getThrees(){
        return this.allScores.get("Threes");
    }
    public boolean setFours(int newFours){
        return this.updateScoreIfAllowed("Fours", newFours);
    }
    private int getFours(){
        return this.allScores.get("Fours");
    }
    public boolean setFives(int newFives){
        return this.updateScoreIfAllowed("Fives", newFives);
    }
    private int getFives(){
        return this.allScores.get("Fives");
    }
    public boolean setSixes(int newSixes){
        return this.updateScoreIfAllowed("Sixes", newSixes);
    }
    private int getSixes(){
        return this.allScores.get("Sixes");
    }
    private void setUpperPreTotal(int newUpperPreTotal){
        this.allScores.replace("UpperPreTotal", newUpperPreTotal);
    }
    private int getUpperPreTotal(){
        return this.allScores.get("UpperPreTotal");
    }
    private void calculateUpperPreTotal(){
        int total = this.getOnes() + this.getTwos() + this.getThrees() +
                this.getFours() + this.getFives() + this.getSixes();
        this.setUpperPreTotal(total);
    }
    private void calculateBonus(){
        this.calculateUpperPreTotal();
        int bonusThreshold = 63;
        int bonusScore = 0;
        if(this.getUpperPreTotal() >= bonusThreshold){
            bonusScore += 35;
        }
        this.setBonus(bonusScore);
    }
    private void setBonus(int newBonus){
        this.allScores.replace("Bonus", newBonus);
    }
    private int getBonus() {
        return this.allScores.get("Bonus");
    }
    private void calculateUpperTotal(){
        this.calculateBonus();
        int total = 0;
        if (this.getUpperPreTotal() > 0){
            total += this.getUpperPreTotal();
        }
        if (this.getBonus() > 0){
            total += this.getBonus();
        }
        this.setUpperTotal(total);
    }
    private void setUpperTotal(int newUpperTotal){
        this.allScores.replace("UpperTotal", newUpperTotal);
    }
    private int getUpperTotal(){
        return this.allScores.get("UpperTotal");
    }

    public boolean setThreeOfKind(int newThreeOfKind){
        return this.updateScoreIfAllowed("ThreeOfKind", newThreeOfKind);
    }
    private int getThreeOfKind(){
        return this.allScores.get("ThreeOfKind");
    }
    public boolean setFourOfKind(int newFourOfKind){
        return this.updateScoreIfAllowed("FourOfKind", newFourOfKind);
    }
    private int getFourOfKind(){
        return this.allScores.get("FourOfKind");
    }
    public boolean setFullHouse(int newFullHouse){
        return this.updateScoreIfAllowed("FullHouse", newFullHouse);
    }
    private int getFullHouse(){
        return this.allScores.get("FullHouse");
    }
    public boolean setSmallStraight(int newSmallStraight){
        return this.updateScoreIfAllowed("SmallStraight", newSmallStraight);
    }
    private int getSmallStraight(){
        return this.allScores.get("SmallStraight");
    }
    public boolean setLargeStraight(int newLargeStraight){
        return this.updateScoreIfAllowed("LargeStraight", newLargeStraight);
    }
    private int getLargeStraight(){
        return this.allScores.get("LargeStraight");
    }
    public boolean setYahtzee(int newYahtzee){
        return this.updateScoreIfAllowed("YAHTZEE", newYahtzee);
    }
    private int getYahtzee(){
        return this.allScores.get("YAHTZEE");
    }
    public boolean setChance(int newChance){
        return this.updateScoreIfAllowed("Chance", newChance);
    }
    private int getChance(){
        return this.allScores.get("Chance");
    }
    private void setBonusYahtzee(int newBonusYahtzee){
        this.allScores.replace("YahtzeeBonus", newBonusYahtzee);
    }
    private int getBonusYahtzee(){
        return this.allScores.get("YahtzeeBonus");
    }
    public void incrementBonusYahtzeeCount(){
        int currentCount = this.getBonusYahtzeeCount();
        int defaultValue = 1;
        if(currentCount == -1){
            this.setBonusYahtzeeCount(defaultValue);
        }else{
            currentCount++;
            this.setBonusYahtzeeCount(currentCount);
        }
    }
    private void setBonusYahtzeeCount(int newBonusYahtzeeCount){
        this.allScores.replace("BonusYahtzeeCount", newBonusYahtzeeCount);
    }
    private int getBonusYahtzeeCount(){
        return this.allScores.get("BonusYahtzeeCount");
    }

    private void setLowerTotal(int newLowerTotal){
        this.allScores.replace("LowerTotal", newLowerTotal);
    }
    private int getLowerTotal(){
        return this.allScores.get("LowerTotal");
    }
    private void calculateLowerTotal(){
        int currentBonusCount = this.getBonusYahtzeeCount();
        if(currentBonusCount != -1){
            this.setBonusYahtzee(currentBonusCount * 100);
        }
        int total = this.getThreeOfKind() + this.getFourOfKind() + this.getFullHouse() +  this.getSmallStraight()
                + this.getLargeStraight() + this.getYahtzee() + this.getChance() + this.getBonusYahtzee();
        this.setLowerTotal(total);
    }
    private void setGrandTotal(int newGrandTotal){
        this.allScores.replace("GrandTotal", newGrandTotal);
    }
    private int getGrandTotal(){
        return this.allScores.get("GrandTotal");
    }
    public void calculateGrandTotal(){
        this.calculateUpperTotal();
        this.calculateLowerTotal();
        this.setGrandTotal(this.getUpperTotal() + this.getLowerTotal());
    }

    public String getValue(String desiredValue){
        int valueIn = this.allScores.get(desiredValue);
        if (valueIn >= 0 ){
            return ("" + valueIn);
        }
        else{ return " "; }
    }

    /**
     * @return String to print Yahtzee score card. Zeros are shown but unused values return empty
     */
    public String getCard(){
        String lineSpacer = "| %-13s | %4s |\n";
        String frame = "+---------------+------+\n";

        String tempString;
        tempString = "YAHTZEE\n" +
                "UPPER SECTION\n" +
                frame +
                String.format(lineSpacer, "Ones", this.getValue("Ones")) +
                String.format(lineSpacer, "Twos", this.getValue("Twos")) +
                String.format(lineSpacer, "Threes", this.getValue("Threes")) +
                String.format(lineSpacer, "Fours", this.getValue("Fours")) +
                String.format(lineSpacer, "Fives", this.getValue("Fives")) +
                String.format(lineSpacer, "Sixes", this.getValue("Sixes")) +
                String.format(lineSpacer, "TOTAL", this.getValue("UpperPreTotal")) +
                String.format(lineSpacer, "BONUS", this.getValue("Bonus")) +
                String.format(lineSpacer, "TOTAL UPPER", this.getValue("UpperTotal")) +
                frame +
                "LOWER SECTION\n" +
                frame +
                String.format(lineSpacer, "3 of a Kind", this.getValue("ThreeOfKind")) +
                String.format(lineSpacer, "4 of a Kind", this.getValue("FourOfKind")) +
                String.format(lineSpacer, "Full House", this.getValue("FullHouse")) +
                String.format(lineSpacer, "SM Straight", this.getValue("SmallStraight")) +
                String.format(lineSpacer, "LG Straight", this.getValue("LargeStraight")) +
                String.format(lineSpacer, "YAHTZEE", this.getValue("YAHTZEE")) +
                String.format(lineSpacer, "Chance", this.getValue("Chance")) +
                String.format(lineSpacer, "BONUS Count", this.getValue("BonusYahtzeeCount")) +
                String.format(lineSpacer, "YAHTZEE BONUS", this.getValue("YahtzeeBonus")) +
                String.format(lineSpacer, "TOTAL LOWER", this.getValue("LowerTotal")) +
                String.format(lineSpacer, "TOTAL UPPER", this.getValue("UpperTotal")) +
                String.format(lineSpacer, "GRAND TOTAL", this.getValue("GrandTotal")) +
                frame;
        return tempString;
    }

    /**
     * @return String of printable lines showing all the hands as they are
     */
    public String toString(){
        StringBuilder tempString = new StringBuilder();
        tempString.append("All 13 pre-rolled hands for a game:\n");
        for(int i = 0; i < this.totalHandsForCard; i++){
            tempString.append("Hand- ").append(i + 1).append(", ").append(this.gameHands.get(i)).append("\n");
        }
        return tempString.toString();
    }
}
