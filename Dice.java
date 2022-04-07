import java.util.Random;

public class Dice {

    private int numberOfDice;
    Dice(int numberOfDice) {

        this.numberOfDice = numberOfDice;
    }

    int rollDice()
    {
        return (new Random().nextInt(6-1)+1);
    }
    
}
