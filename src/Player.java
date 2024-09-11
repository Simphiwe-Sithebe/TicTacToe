import java.util.Scanner;

public class Player {
    protected char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(Board board, Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + symbol + ", enter your move (row and column): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)) {
                board.placeMove(row, col, symbol);
                break;
            } else {
                System.out.println("This move is not valid.");
            }
        }
    }
}
