
import java.util.Scanner;

public class Game {

    private Board board;
    private char currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = 'X'; // Player X starts first
    }

    // Start the game loop
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        System.out.println("Welcome to Tic-Tac-Toe!");
        board.displayBoard();

        while (!gameWon) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Make a move
            if (board.makeMove(row, col, currentPlayer)) {
                board.displayBoard();

                // Check for win or draw
                if (board.checkWin(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                } else if (board.isDraw()) {
                    System.out.println("It's a draw!");
                    break;
                } else {
                    // Switch player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
}
