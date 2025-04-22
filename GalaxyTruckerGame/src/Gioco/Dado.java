package Gioco;
import java.util.Random;

public class Dado {
    private static final int FACCE = 6;
    private Random random;

    public Dado() {
        random = new Random();
    }

    public int tira() {
        return random.nextInt(FACCE) + 1; // da 1 a 6 inclusi
    }
}