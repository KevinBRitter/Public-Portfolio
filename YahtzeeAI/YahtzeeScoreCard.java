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
// TODO: All these methods should be properly documented.  Save till after finals May 2020.
    private void populateScores(){
        for(int i = 0; i < allScoresListSize; i++){
            this.gameScores.add(-1);
        }
    }
    public void setOnes(int newOnes){
        this.gameScores.set(0, newOnes);
    }
    public int getOnes(){
            return this.gameScores.get(0);
    }
    public void setTwos(int newTwos){
        this.gameScores.set(1, newTwos);
    }
    public int getTwos(){
        return this.gameScores.get(1);
    }
    public void setThrees(int newThrees){
        this.gameScores.set(2, newThrees);
    }
    public int getThrees(){
        return this.gameScores.get(2);
    }
    public void setFours(int newFours){
        this.gameScores.set(3, newFours);
    }
    public int getFours(){
        return this.gameScores.get(3);
    }
    public void setFives(int newFives){
        this.gameScores.set(4, newFives);
    }
    public int getFives(){
        return this.gameScores.get(4);
    }
    public void setSixes(int newSixes){
        this.gameScores.set(5, newSixes);
    }
    public int getSixes(){
        return this.gameScores.get(5);
    }
    public void setUpperPreTotal(int newUpperPreTotal){
        this.gameScores.set(6, newUpperPreTotal);
    }
    public int getUpperPreTotal(){
        return this.gameScores.get(6);
    }
    private void calculateUpperPreTotal(){
        int total = 0;
        for(int i = 0; i < this.topGroupSize; i++){
            if(this.gameScores.get(i) > 0){
                total += this.gameScores.get(i);
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
    public void setBonus(int newBonus){
        this.gameScores.set(7, newBonus);
    }
    public int getBonus() {
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

    public void setUpperTotal(int newUpperTotal){
        this.gameScores.set(8, newUpperTotal);
    }
    public int getUpperTotal(){
        return this.gameScores.get(8);
    }


    public void setThreeOfKind(int newThreeOfKind){
        this.gameScores.set(9, newThreeOfKind);
    }
    public int getThreeOfKind(){
        return this.gameScores.get(9);
    }
    public void setFourOfKind(int newFourOfKind){
        this.gameScores.set(10, newFourOfKind);
    }
    public int getFourOfKind(){
        return this.gameScores.get(10);
    }
    public void setFullHouse(int newFullHouse){
        this.gameScores.set(11, newFullHouse);
    }
    public int getFullHouse(){
            return this.gameScores.get(11);
        }
    public void setSmallStraight(int newSmallStraight){
        this.gameScores.set(12, newSmallStraight);
    }
    public int getSmallStraight(){
        return this.gameScores.get(12);
    }
    public void setLargeStraight(int newLargeStraight){
        this.gameScores.set(13, newLargeStraight);
    }
    public int getLargeStraight(){
        return this.gameScores.get(13);
    }
    public void setYahtzee(int newYahtzee){
        this.gameScores.set(14, newYahtzee);
    }
    public int getYahtzee(){
        return this.gameScores.get(14);
    }
    public void setChance(int newChance){
        this.gameScores.set(15, newChance);
    }
    public int getChance(){
        return this.gameScores.get(15);
    }
    public void setBonusYahtzee(int newBonusYahtzee){
        this.gameScores.set(16, newBonusYahtzee);
    }
    public int getBonusYahtzee(){
        return this.gameScores.get(16);
    }
    public void setBonusYahtzeeCount(int newBonusYahtzeeCount){
        this.gameScores.set(17, newBonusYahtzeeCount);
    }
    public int getBonusYahtzeeCount(){
        return this.gameScores.get(17);
    }
    public void setLowerTotal(int newLowerTotal){
        this.gameScores.set(18, newLowerTotal);
    }
    public int getLowerTotal(){
        return this.gameScores.get(18);
    }
    public void calculateLowerTotal(){
        if(this.getBonusYahtzeeCount() > 0){
            this.setBonusYahtzee(this.getBonusYahtzeeCount() * 100);
        }
        int total = 0;
        for(int i = this.bottomScoresListStart; i < this.bottomScoresListEnd; i++){
            if(this.gameScores.get(i) > 0){
                total += this.gameScores.get(i);
            }
        }
        this.setLowerTotal(total);
    }
    public void setGrandTotal(int newGrandTotal){
        this.gameScores.set(19, newGrandTotal);
    }
    public int getGrandTotal(){
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
