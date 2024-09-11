import java.util.Random;
import java.util.Scanner;

public class AIPlayer extends Player {
    private Random random;

    public AIPlayer(char symbol) {
        super(symbol);
        random = new Random();
    }

    @Override
    public void makeMove(Board board, Scanner scanner) {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.isCellEmpty(row, col));

        System.out.println("AI Player " + getSymbol() + " makes a move at (" + (row + 1) + ", " + (col + 1) + ")");
        board.placeMove(row, col, getSymbol());
    }
}
