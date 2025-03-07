package ch.jduke;

public class Grid {
    private Player[] grid;

    public Grid() {
        grid = new Player[]{
                Player.None, Player.None, Player.None,
                Player.None, Player.None, Player.None,
                Player.None, Player.None, Player.None
        };    }

    public void mark(Position position, Player actualPlayer) {
        grid[position.ordinal()] = actualPlayer;
    }

    public Player getWinner() {
        if (
                grid[Position.TopLeft.ordinal()] == grid[Position.MiddleCenter.ordinal()] &&
                grid[Position.MiddleCenter.ordinal()] == grid[Position.BottomRight.ordinal()] &&
                grid[Position.TopLeft.ordinal()] != Player.None
        ) {
            return grid[Position.TopLeft.ordinal()];
        }
        if (
                grid[Position.TopRight.ordinal()] == grid[Position.MiddleCenter.ordinal()] &&
                grid[Position.MiddleCenter.ordinal()] == grid[Position.BottomLeft.ordinal()] &&
                grid[Position.TopRight.ordinal()] != Player.None
        ) {
            return grid[Position.TopRight.ordinal()];
        }
        return Player.None;

    }
}
