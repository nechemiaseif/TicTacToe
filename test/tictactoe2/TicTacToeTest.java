// Nechemia Seif
package tictactoe2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

    @Test
    public void hasWinnerRow0() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(0, 0, Cell.X);
        game.setCell(0, 1, Cell.X);
        game.setCell(0, 2, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void hasWinnerRow1() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(1, 0, Cell.X);
        game.setCell(1, 1, Cell.X);
        game.setCell(1, 2, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void hasWinnerRow2() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(2, 0, Cell.X);
        game.setCell(2, 1, Cell.X);
        game.setCell(2, 2, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void hasWinnerColumn0() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(0, 0, Cell.X);
        game.setCell(1, 0, Cell.X);
        game.setCell(2, 0, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void hasWinnerColumn1() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(0, 1, Cell.X);
        game.setCell(1, 1, Cell.X);
        game.setCell(2, 1, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void hasWinnerColumn2() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(0, 2, Cell.X);
        game.setCell(1, 2, Cell.X);
        game.setCell(2, 2, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void hasWinnerDiagonal1() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(0, 0, Cell.X);
        game.setCell(1, 1, Cell.X);
        game.setCell(2, 2, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void hasWinnerDiagonal2() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(0, 2, Cell.X);
        game.setCell(1, 1, Cell.X);
        game.setCell(2, 0, Cell.X);

        boolean actual = game.hasWinner();

        assertTrue(actual);
    }

    @Test
    public void isDraw() {
        TicTacToe game = new TicTacToe(2);

        game.generateDraw();

        boolean actual = game.isDraw();

        assertTrue(actual);
    }

    @Test
    public void getWinnerX() {
        TicTacToe game = new TicTacToe(2);
        game.togglePlayer();
       
        game.setCell(1, 0, Cell.X);
        game.setCell(1, 1, Cell.X);
        game.setCell(1, 2, Cell.X);

        assertEquals("X", game.getWinner().toString());
    }
    
    @Test
    public void getWinnerO() {
        TicTacToe game = new TicTacToe(2);

        game.setCell(1, 0, Cell.O);
        game.setCell(1, 1, Cell.O);
        game.setCell(1, 2, Cell.O);

        assertEquals("O", game.getWinner().toString());
    }
     
    @Test
    public void getWinnerNone() {
        TicTacToe game = new TicTacToe(2);

        game.generateDraw();

        assertEquals("NONE", game.getWinner().toString());
    }

    @Test
    public void isValidMoveInRangeReturnsTrue() {
        TicTacToe game = new TicTacToe(2);

        boolean actual = game.isValidMove(0, 0);

        assertTrue(actual);
    }

    @Test
    public void isValidMoveOutOfRangeReturnsFalse() {
        TicTacToe game = new TicTacToe(2);

        boolean actual1 = game.isValidMove(3, 0);
        boolean actual2 = game.isValidMove(0, 3);

        assertFalse(actual1);
        assertFalse(actual2);
    }

    @Test
    public void isValidMoveCellOccupiedReturnsFalse() {
        TicTacToe game = new TicTacToe(2);
        game.setCell(0, 0, Cell.X);

        boolean actual = game.isValidMove(0, 0);

        assertFalse(actual);
    }
}
