package ch.jduke;

public class TicTacToe {
    private Player actualPlayer = Player.X;
    private Grid grid = new Grid();

    public Player getPlayer() {
        return actualPlayer;
    }

    public void mark(Position position) {
        grid.assertPositionIsNotMarked(position);
        grid.mark(position, actualPlayer);
        changePlayer();
    }

    private void changePlayer() {
        if (actualPlayer == Player.X) {
            actualPlayer = Player.O;
            return;
        }
        actualPlayer = Player.X;
    }

    public Player getWinner() {
        return grid.getWinner();
    }
}
