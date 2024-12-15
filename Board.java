
public class Board {

    private char[][] grid; // 3x3 grid for the game board

    // Constructor: Initialize the board with empty spaces
    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' '; // Empty space
            }
        }
    }

    // Display the current game board
    public void displayBoard() {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  ---------");
            }
        }
    }

    // Make a move on the board
    public boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' ') {
            grid[row][col] = player;
            return true;
        }
        return false;
    }

    // Check for a win
    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if ((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player)
                    || (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        if ((grid[0][0] == player && grid[1][1] == player && grid[2][2] == player)
                || (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player)) {
            return true;
        }
        return false;
    }

    // Check for a draw
    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return false; // There's still an empty space
                }
            }
        }
        return true; // No empty spaces, it's a draw
    }
}
