import java.util.Scanner;

public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.board = new Board();
        this.playerX = new Player('X');
        this.playerO = new AIPlayer('O');
        this.currentPlayer = playerX;
        this.scanner = scanner;
    }

    public void start() {
        boolean gameWon = false;
        boolean gameDrawn = false;

        while (!gameWon && !gameDrawn) {
            board.printBoard();
            currentPlayer.makeMove(board, scanner);
            gameWon = board.checkWin(currentPlayer.getSymbol());
            gameDrawn = board.checkDraw();

            if (!gameWon && !gameDrawn) {
                switchPlayer();
            }
        }

        board.printBoard();

        if (gameWon) {
            System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
}
