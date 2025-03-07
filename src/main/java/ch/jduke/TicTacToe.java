package ch.jduke;

import java.util.Objects;

public class TicTacToe {
    private Player actualPlayer = Player.X;

    public Player getPlayer() {
        return actualPlayer;
    }

    public void mark(Position position) {
        changePlayer();
    }

    private void changePlayer() {
        if (actualPlayer == Player.X) {
            actualPlayer = Player.O;
            return;
        }
        actualPlayer = Player.X;
    }
}
