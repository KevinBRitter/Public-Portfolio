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
        for(int i = 0; i < 13; i++){
            this.gameHands.add(new DiceHand());
        }
    }

    private void populateScores(){
        for(int i = 0; i < 20; i++){
            this.gameScores.add(-1);
        }
    }
    public void setOnes(int newOnes){
        this.gameScores.set(0, newOnes);
    }
    public String getOnes(){
        if (this.gameScores.get(0) > 0 ){
            return this.gameScores.get(0).toString();
        }
        else{ return " "; }
    }
    public void setTwos(int newTwos){
        this.gameScores.set(1, newTwos);
    }
    public String getTwos(){
        if (this.gameScores.get(1) > 0 ){
            return this.gameScores.get(1).toString();
        }
        else{ return " "; }
    }
    public void setThrees(int newThrees){
        this.gameScores.set(2, newThrees);
    }
    public String getThrees(){
        if (this.gameScores.get(2) > 0 ){
            return this.gameScores.get(2).toString();
        }
        else{ return " "; }
    }
    public void setFours(int newFours){
        this.gameScores.set(3, newFours);
    }
    public String getFours(){
        if (this.gameScores.get(3) > 0 ){
            return this.gameScores.get(3).toString();
        }
        else{ return " "; }
    }
    public void setFives(int newFives){
        this.gameScores.set(4, newFives);
    }
    public String getFives(){
        if (this.gameScores.get(4) > 0 ){
            return this.gameScores.get(4).toString();
        }
        else{ return " "; }
    }
    public void setSixes(int newSixes){
        this.gameScores.set(5, newSixes);
    }
    public String getSixes(){
        if (this.gameScores.get(5) > 0 ){
            return this.gameScores.get(5).toString();
        }
        else{ return " "; }
    }
    public void setUpperPreTotal(int newUpperPreTotal){
        this.gameScores.set(6, newUpperPreTotal);
    }
    public String getUpperPreTotal(){
        if (this.gameScores.get(6) > 0 ){
            return this.gameScores.get(6).toString();
        }
        else{ return " "; }
    }
    private void calculateUpperPreTotal(){
        int total = 0;
        for(int i = 0; i < 6; i++){
            if(this.gameScores.get(i) > 0){
                total += this.gameScores.get(i);
            }
        }
        this.setUpperPreTotal(total);
    }
    private void calculateBonus(){
        this.calculateUpperPreTotal();
        if(this.gameScores.get(6) >= 63){
            this.setBonus(35);
        }
    }
    private void calculateUpperTotal(){
        this.calculateBonus();
        int total = 0;
        if (this.gameScores.get(6) > 0){
            total += this.gameScores.get(6);
        }
        if (this.gameScores.get(7) > 0){
            total += this.gameScores.get(7);
        }
        this.setUpperTotal(total);
    }
    public void setBonus(int newBonus){
        this.gameScores.set(7, newBonus);
    }
    public String getBonus(){
        if (this.gameScores.get(7) > 0 ){
            return this.gameScores.get(7).toString();
        }
        else{ return " "; }
    }
    public void setUpperTotal(int newUpperTotal){
        this.gameScores.set(8, newUpperTotal);
    }
    public String getUpperTotal(){
        if (this.gameScores.get(8) > 0 ){
            return this.gameScores.get(8).toString();
        }
        else{ return " "; }
    }
    public void setThreeOfKind(int newThreeOfKind){
        this.gameScores.set(9, newThreeOfKind);
    }
    public String getThreeOfKind(){
        if (this.gameScores.get(9) > 0 ){
            return this.gameScores.get(9).toString();
        }
        else{ return " "; }
    }
    public void setFourOfKind(int newFourOfKind){
        this.gameScores.set(10, newFourOfKind);
    }
    public String getFourOfKind(){
        if (this.gameScores.get(10) > 0 ){
            return this.gameScores.get(10).toString();
        }
        else{ return " "; }
    }
    public void setFullHouse(int newFullHouse){
        this.gameScores.set(11, newFullHouse);
    }
    public String getFullHouse(){
        if (this.gameScores.get(11) > 0 ){
            return this.gameScores.get(11).toString();
        }
        else{ return " "; }
    }
    public void setSmallStraight(int newSmallStraight){
        this.gameScores.set(12, newSmallStraight);
    }
    public String getSmallStraight(){
        if (this.gameScores.get(12) > 0 ){
            return this.gameScores.get(12).toString();
        }
        else{ return " "; }
    }
    public void setLargeStraight(int newLargeStraight){
        this.gameScores.set(13, newLargeStraight);
    }
    public String getLargeStraight(){
        if (this.gameScores.get(13) > 0 ){
            return this.gameScores.get(13).toString();
        }
        else{ return " "; }
    }
    public void setYahtzee(int newYahtzee){
        this.gameScores.set(14, newYahtzee);
    }
    public String getYahtzee(){
        if (this.gameScores.get(14) > 0 ){
            return this.gameScores.get(14).toString();
        }
        else{ return " "; }
    }
    public void setChance(int newChance){
        this.gameScores.set(15, newChance);
    }
    public String getChance(){
        if (this.gameScores.get(15) > 0 ){
            return this.gameScores.get(15).toString();
        }
        else{ return " "; }
    }
    public void setBonusYahtzee(int newBonusYahtzee){
        this.gameScores.set(16, newBonusYahtzee);
    }
    public String getBonusYahtzee(){
        if (this.gameScores.get(16) > 0 ){
            return this.gameScores.get(16).toString();
        }
        else{ return " "; }
    }
    public void setBonusYahtzeeCount(int newBonusYahtzeeCount){
        this.gameScores.set(17, newBonusYahtzeeCount);
    }
    public String getBonusYahtzeeCount(){
        if (this.gameScores.get(17) > 0 ){
            return this.gameScores.get(17).toString();
        }
        else{ return " "; }
    }
    public void setLowerTotal(int newLowerTotal){
        this.gameScores.set(18, newLowerTotal);
    }
    public String getLowerTotal(){
        if (this.gameScores.get(18) > 0 ){
            return this.gameScores.get(18).toString();
        }
        else{ return " "; }
    }
    public void setGrandTotal(int newGrandTotal){
        this.gameScores.set(19, newGrandTotal);
    }
    public String getGrandTotal(){
        if (this.gameScores.get(19) > 0 ){
            return this.gameScores.get(19).toString();
        }
        else{ return " "; }
    }

    public String getCard(){
        String lineSpacer = "| %-13s | %2s |\n";

        String tempString;
        tempString = "YAHTZEE\n" +
                "UPPER SECTION\n" +
                String.format(lineSpacer, "Aces", this.getOnes()) +
                String.format(lineSpacer, "Twos", this.getTwos()) +
                String.format(lineSpacer, "Threes", this.getThrees()) +
                String.format(lineSpacer, "Fours", this.getFours()) +
                String.format(lineSpacer, "Fives", this.getFives()) +
                String.format(lineSpacer, "Sixes", this.getSixes()) +
                String.format(lineSpacer, "Total", this.getUpperPreTotal()) +
                String.format(lineSpacer, "Bonus", this.getBonus()) +
                String.format(lineSpacer, "TOTAL", this.getUpperTotal()) +
                "LOWER SECTION\n" +
                String.format(lineSpacer, "3 of a Kind", this.getThreeOfKind()) +
                String.format(lineSpacer, "4 of a Kind", this.getFourOfKind()) +
                String.format(lineSpacer, "Full House", this.getFullHouse()) +
                String.format(lineSpacer, "SM Straight", this.getSmallStraight()) +
                String.format(lineSpacer, "LG Straight", this.getLargeStraight()) +
                String.format(lineSpacer, "YAHTZEE", this.getYahtzee()) +
                String.format(lineSpacer, "Chance", this.getChance()) +
                String.format(lineSpacer, "Yahtzee Bonus", this.getBonusYahtzee()) +
                String.format(lineSpacer, "Bonus Count", this.getBonusYahtzeeCount()) +
                String.format(lineSpacer, "TOTAL", this.getLowerTotal()) +
                String.format(lineSpacer, "TOTAL", this.getUpperTotal()) +
                String.format(lineSpacer, "GRAND TOTAL", this.getGrandTotal());
        return tempString;
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
