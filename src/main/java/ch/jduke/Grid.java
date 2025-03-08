package ch.jduke;

public class Grid {
    private Player[] grid = {
            Player.None, Player.None, Player.None,
            Player.None, Player.None, Player.None,
            Player.None, Player.None, Player.None
    };

    private WinningPositions winningPositions = new WinningPositions();


    public void mark(Position position, Player actualPlayer) {
        grid[position.ordinal()] = actualPlayer;
    }

    public Player getWinner() {
        return winningPositions.checkWin(makeCopyOfGrid()).player();
    }

    private Player[] makeCopyOfGrid() {
        return grid.clone();
    }

    public void assertPositionIsNotMarked(Position position) {
        if (grid[position.ordinal()] != Player.None) {
            throw new IllegalArgumentException("Position " + position + " is already marked");
        }
    }
}
