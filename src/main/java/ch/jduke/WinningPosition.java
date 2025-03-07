package ch.jduke;

public record WinningPosition(Position p1, Position p2, Position p3) {

    public WinningState check(Player[] grid) {
        if ( grid[p1.ordinal()] == grid[p2.ordinal()] &&
                grid[p2.ordinal()] == grid[p3.ordinal()] &&
                grid[p1.ordinal()] != Player.None) {
            return new WinningState(true, grid[p1.ordinal()]);
        }
        return new WinningState(false, Player.None);
    }

}

