package ch.jduke;

import java.util.Objects;

public class TicTacToe {
    private Player actualPlayer = Player.X;
    private Player[]  grid;

    public TicTacToe() {
        grid = new Player[] {
                Player.None, Player.None, Player.None,
                Player.None, Player.None, Player.None,
                Player.None, Player.None, Player.None
        };
    }

    public Player getPlayer() {
        return actualPlayer;
    }

    public void mark(Position position) {
        grid[position.ordinal()] = actualPlayer;
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
        if (
                grid[Position.TopLeft.ordinal()] == grid[Position.MiddleCenter.ordinal()] &&
                grid[Position.MiddleCenter.ordinal()] == grid[Position.BottomRight.ordinal()] &&
                grid[Position.TopLeft.ordinal()] != Player.None
        ) {
            return grid[Position.TopLeft.ordinal()];
        }
        return Player.None;
    }
}
