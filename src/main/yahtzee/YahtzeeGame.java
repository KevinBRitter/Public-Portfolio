package main.yahtzee;

public class YahtzeeGame {
    YahtzeeScoreCard scoreCard;
    public void newGame() {
        this.scoreCard = new YahtzeeScoreCard();
    }

    public void printScoreCard() {
        System.out.println();
        System.out.println(this.scoreCard.getCard());
    }

    public Object getGameState() {
        return scoreCard.getGameState();
    }
}
