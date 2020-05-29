package YahtzeeAI;

import java.util.ArrayList;
// TODO: All methods should be properly documented before moving on.
/**
 * class Yahtzee Score Card creates a series of dice hands each
 * representing a single round in a game.  Each round is played by
 * an agent for up to three turns, or scored if preferred.  These
 * follow the standard Yahtzee rule book.  At each step the agent is
 * given a list of the current state of the game for evaluation and
 * decision making.
 */
public class YahtzeeScoreCard {
    ArrayList<DiceHand> gameHands;
    ArrayList<Integer> gameScores;
    final int totalHandsForCard = 13;
    final int allScoresListSize = 20;
    final int topGroupSize = 6;
    final int bottomScoresListStart = 9;
    final int bottomScoresListEnd = 17;

    /**
     * default constructor makes a new games worth of rounds
     * and calls the populate game hands method
     */
    public YahtzeeScoreCard(){
        this.gameHands = new ArrayList<>();
        this.gameScores = new ArrayList<>();
        this.populateGameHands();
        this.populateScores();
    }

    /**
     * populate game hand method fills the rounds with new hands
     */
    private void populateGameHands(){
        for(int i = 0; i < this.totalHandsForCard; i++){
            this.gameHands.add(new DiceHand());
        }
    }

    /**
     * All scores given initial value of -1 indicating they haven't been scored yet.
     */
    private void populateScores(){
        int defaultValue = -1;
        for(int i = 0; i < allScoresListSize; i++){
            this.gameScores.add(defaultValue);
        }
    }

    /**
     * Try New Value is used by all score card setters accessible to an agent.  It
     * checks if a location has already been filled before filling if able.
     * @param location index of score in ArrayList gameScores
     * @param newValue value to place at location
     * @return boolean of whether replace was allowed.
     */
    private boolean tryNewValue(int location, int newValue){
        if(this.gameScores.get(location) == -1){
            this.gameScores.set(location, newValue);
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param newOnes
     * @return
     */
    public boolean setOnes(int newOnes){
        return this.tryNewValue(0, newOnes);
    }
    public int getOnes(){
            return this.gameScores.get(0);
    }
    public boolean setTwos(int newTwos){
        return this.tryNewValue(1, newTwos);
    }
    public int getTwos(){
        return this.gameScores.get(1);
    }
    public boolean setThrees(int newThrees){
        return this.tryNewValue(2, newThrees);
    }
    public int getThrees(){
        return this.gameScores.get(2);
    }
    public boolean setFours(int newFours){
        return this.tryNewValue(3, newFours);
    }
    public int getFours(){
        return this.gameScores.get(3);
    }
    public boolean setFives(int newFives){
        return this.tryNewValue(4, newFives);
    }
    public int getFives(){
        return this.gameScores.get(4);
    }
    public boolean setSixes(int newSixes){
        return this.tryNewValue(5, newSixes);
    }
    public int getSixes(){
        return this.gameScores.get(5);
    }
    private void setUpperPreTotal(int newUpperPreTotal){
        this.gameScores.set(6, newUpperPreTotal);
    }
    private int getUpperPreTotal(){
        return this.gameScores.get(6);
    }
    private void calculateUpperPreTotal(){
        int total = 0;
        int tempScore;
        for(int i = 0; i < this.topGroupSize; i++){
            tempScore = this.gameScores.get(i);
            if(tempScore > 0){
                total += tempScore;
            }
        }
        this.setUpperPreTotal(total);
    }
    private void calculateBonus(){
        this.calculateUpperPreTotal();
        if(this.getUpperPreTotal() >= 63){
            this.setBonus(35);
        }
        else{
            this.setBonus(0);
        }
    }
    private void setBonus(int newBonus){
        this.gameScores.set(7, newBonus);
    }

    private int getBonus() {
        return this.gameScores.get(7);
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
        this.gameScores.set(8, newUpperTotal);
    }
    private int getUpperTotal(){
        return this.gameScores.get(8);
    }


    public boolean setThreeOfKind(int newThreeOfKind){
        return this.tryNewValue(9, newThreeOfKind);
    }
    public int getThreeOfKind(){
        return this.gameScores.get(9);
    }
    public boolean setFourOfKind(int newFourOfKind){
        return this.tryNewValue(10, newFourOfKind);
    }
    public int getFourOfKind(){
        return this.gameScores.get(10);
    }
    public boolean setFullHouse(int newFullHouse){
        return this.tryNewValue(11, newFullHouse);
    }
    public int getFullHouse(){
        return this.gameScores.get(11);
    }
    public boolean setSmallStraight(int newSmallStraight){
        return this.tryNewValue(12, newSmallStraight);
    }
    public int getSmallStraight(){
        return this.gameScores.get(12);
    }
    public boolean setLargeStraight(int newLargeStraight){
        return this.tryNewValue(13, newLargeStraight);
    }
    public int getLargeStraight(){
        return this.gameScores.get(13);
    }
    public boolean setYahtzee(int newYahtzee){
        return this.tryNewValue(14, newYahtzee);
    }
    public int getYahtzee(){
        return this.gameScores.get(14);
    }
    public boolean setChance(int newChance){
        return this.tryNewValue(15, newChance);
    }
    public int getChance(){
        return this.gameScores.get(15);
    }
    private void setBonusYahtzee(int newBonusYahtzee){
        this.gameScores.set(16, newBonusYahtzee);
    }
    private int getBonusYahtzee(){
        return this.gameScores.get(16);
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
        this.gameScores.set(17, newBonusYahtzeeCount);
    }
    private int getBonusYahtzeeCount(){
        return this.gameScores.get(17);
    }

    private void setLowerTotal(int newLowerTotal){
        this.gameScores.set(18, newLowerTotal);
    }
    public int getLowerTotal(){
        return this.gameScores.get(18);
    }
    public void calculateLowerTotal(){
        int currentBonusCount = this.getBonusYahtzeeCount();
        if(currentBonusCount != -1){
            this.setBonusYahtzee(currentBonusCount * 100);
        }
        int total = 0;
        int currentScore;
        for(int i = this.bottomScoresListStart; i < this.bottomScoresListEnd; i++){
            currentScore = this.gameScores.get(i);
            if(currentScore > 0){
                total += currentScore;
            }
        }
        this.setLowerTotal(total);
    }
    private void setGrandTotal(int newGrandTotal){
        this.gameScores.set(19, newGrandTotal);
    }
    private int getGrandTotal(){
        return this.gameScores.get(19);
    }
    public void calculateGrandTotal(){
        this.calculateUpperTotal();
        this.calculateLowerTotal();
        this.setGrandTotal(this.getUpperTotal() + this.getLowerTotal());
    }

    /**
     * @param desiredValue is a String entry denoting the value to be returned ex. "Aces"
     * @return a string representation of the value >= 0 else " "
     * Switch cases allow many varied but identical code blocks, here get value is called.
     */
    public String getValue(String desiredValue){
        int valueIn = -1;
        switch (desiredValue){
            case "Aces":{
                valueIn = this.getOnes();
                break;
            }
            case "Twos":{
                valueIn = this.getTwos();
                break;
            }
            case "Threes":{
                valueIn = this.getThrees();
                break;
            }
            case "Fours":{
                valueIn = this.getFours();
                break;
            }
            case "Fives":{
                valueIn = this.getFives();
                break;
            }
            case "Sixes":{
                valueIn = this.getSixes();
                break;
            }
            case "UpperPreTotal":{
                valueIn = this.getUpperPreTotal();
                break;
            }
            case "Bonus":{
                valueIn = this.getBonus();
                break;
            }
            case "UpperTotal":{
                valueIn = this.getUpperTotal();
                break;
            }
            case "ThreeOfKind":{
                valueIn = this.getThreeOfKind();
                break;
            }
            case "FourOfKind":{
                valueIn = this.getFourOfKind();
                break;
            }
            case "FullHouse":{
                valueIn = this.getFullHouse();
                break;
            }
            case "SmallStraight":{
                valueIn = this.getSmallStraight();
                break;
            }
            case "LargeStraight":{
                valueIn = this.getLargeStraight();
                break;
            }
            case "YAHTZEE":{
                valueIn = this.getYahtzee();
                break;
            }
            case "Chance":{
                valueIn = this.getChance();
                break;
            }
            case "YahtzeeBonus":{
                valueIn = this.getBonusYahtzee();
                break;
            }
            case "BonusYahtzeeCount":{
                valueIn = this.getBonusYahtzeeCount();
                break;
            }
            case "LowerTotal":{
                valueIn = this.getLowerTotal();
                break;
            }
            case "GrandTotal":{
                valueIn = this.getGrandTotal();
                break;
            }
        }
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
                String.format(lineSpacer, "Aces", this.getValue("Aces")) +
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
                String.format(lineSpacer, "YAHTZEE BONUS", this.getValue("YahtzeeBonus")) +
                String.format(lineSpacer, "BONUS Count", this.getValue("BonusYahtzeeCount")) +
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
        for(int i = 0; i < this.totalHandsForCard; i++){
            tempString.append("Hand: ").append(i + 1).append(", ").append(this.gameHands.get(i)).append("\n");
        }
        return tempString.toString();
    }
}
