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
    }
}
