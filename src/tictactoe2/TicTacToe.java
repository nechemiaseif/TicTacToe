// Nechemia Seif
package tictactoe2;

import java.awt.Point;
import java.util.Scanner;

enum Cell {
    NONE, O, X
};

public class TicTacToe {

    private boolean isPlayerOneMove;
    private Cell[][] grid;
    private Point move;

    TicTacToe(int playerCount) {
        grid = new Cell[3][3];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = Cell.NONE;
            }
        }
        move = new Point();
    }

    void displayBoard() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(convertToString(grid[row][col]));
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            if (row < 2) {
                System.out.println("\n----------");
            }
        }
    }

    void promptAndMakeMove() {
        prompt();
        setCell(move.y, move.x, isPlayerOneMove ? Cell.X : Cell.O);
    }

    void prompt() {
        int col, row;
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("\nEnter your move (A1 - C3), Mr. "
                    + (isPlayerOneMove ? "X" : "O") + ": ");
            String userMove = keyboard.next();
            col = userMove.charAt(0) - 'A';
            row = userMove.charAt(1) - '1';
        } while (!isValidMove(col, row));
        move.setLocation(col, row);
    }

    void setCell(int row, int col, Cell cell) {
        grid[row][col] = cell;

    }

    boolean isValidMove(int col, int row) {
        if (col < 0 || col > 2
                || row < 0 || row > 2) {
            System.out.print("Invalid entry. Enter a column "
                    + "(A, B, or C) and a row (1, 2 or 3)"
                    + ", e.g. A1.");
            return false;
        } else if (grid[row][col] != Cell.NONE) {
            System.out.printf("Already an %s in that cell.",
                    grid[row][col]);
            return false;
        } else {
            return true;
        }
    }

    void togglePlayer() {
        isPlayerOneMove = !isPlayerOneMove;
    }

    boolean isGameOver() {
        return hasWinner() || isDraw();
    }

    boolean hasWinner() {
        return (grid[move.y][0] == grid[move.y][1]
                && grid[move.y][1] == grid[move.y][2])
            || (grid[0][move.x] == grid[1][move.x]
                && grid[1][move.x] == grid[2][move.x])
            || (grid[0][0] != Cell.NONE
                && grid[0][0] == grid[1][1]
                && grid[1][1] == grid[2][2])
            || (grid[0][2] != Cell.NONE
                && grid[0][2] == grid[1][1]
                && grid[1][1] == grid[2][0]);
    }

    boolean isDraw() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == Cell.NONE) {
                    return false;
                }
            }
        }
        return (!hasWinner());
    }

    Cell getWinner() {
        if (hasWinner()) {
            return isPlayerOneMove ? Cell.X : Cell.O;
        }
        return Cell.NONE;
    }

    void generateDraw() {
        setCell(0, 0, Cell.O);
        setCell(0, 1, Cell.X);
        setCell(0, 2, Cell.O);
        setCell(1, 0, Cell.X);
        setCell(1, 1, Cell.O);
        setCell(1, 2, Cell.X);
        setCell(2, 0, Cell.X);
        setCell(2, 1, Cell.O);
        setCell(2, 2, Cell.X);
    }

    String convertToString(Cell cell) {
        switch (cell) {
            case NONE:
                return " ";
            case O:
                return "O";
            case X:
                return "X";
            default:
                throw new RuntimeException(cell.toString());
        }
    }
}
