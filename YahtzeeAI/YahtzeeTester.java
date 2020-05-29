package YahtzeeAI;

public class YahtzeeTester {
    public static void main(String[] args) {
        DieObject die = new DieObject(20);
        DieObject defaultDie = new DieObject();
        for(int i = 0; i < 20; i++){
            defaultDie.roll();
            die.roll();
            System.out.printf("Trial: %4d. %23s; %23s.%n" , (i + 1),defaultDie, die);
        }

        DiceHand diceHand = new DiceHand(10);
        DiceHand defaultHand = new DiceHand();
        for(int j = 0; j < 10; j++){
            diceHand.rollHand();
            defaultHand.rollHand();
            System.out.printf("Trial: %4d. %23s; %23s.%n" , (j + 1),diceHand, defaultHand);
        }

        YahtzeeScoreCard scoreCard = new YahtzeeScoreCard();
        System.out.println(scoreCard);
        System.out.println(scoreCard.getCard());

        // TODO: Turn these sets into a game class that allows play to include die re-rolls.
        System.out.println("Test of value replace.");
        if(scoreCard.setOnes(4)){
            System.out.println("Trial 1: Ones set to " + scoreCard.getOnes() + " successful");
        }else{
            System.out.println("Trial 1: Ones already has a value of: " + scoreCard.getOnes());
        }
        if(scoreCard.setOnes(5)){
            System.out.println("Trial 2: Ones set to " + scoreCard.getOnes() + " successful");
        }else{
            System.out.println("Trial 2: Ones already has a value of: " + scoreCard.getOnes());
        }
        System.out.println();

        scoreCard.setTwos(0);
        scoreCard.setThrees(12);
        System.out.println(scoreCard.getCard());
        scoreCard.setFours(16);
        scoreCard.setFives(20);
        scoreCard.setSixes(24);
        scoreCard.setThreeOfKind(18);
        scoreCard.setFourOfKind(21);
        scoreCard.setFullHouse(0);
        scoreCard.setSmallStraight(0);
        scoreCard.setLargeStraight(40);
        scoreCard.setYahtzee(50);
        scoreCard.setChance(15);
        scoreCard.incrementBonusYahtzeeCount();
        scoreCard.calculateGrandTotal();
        System.out.println(scoreCard.getCard());
    }
}
