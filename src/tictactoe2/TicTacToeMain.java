package tictactoe2;

public class TicTacToeMain {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(2);
        do {
            game.togglePlayer();
            game.displayBoard();
            game.promptAndMakeMove();
        } while (!game.isGameOver());
        game.displayBoard();
        System.out.println("\nWinner: " + game.getWinner());

    }

}
