package ch.jduke;

public class Grid {
    private Player[] grid;
    private WinningPositions winningPositions = new WinningPositions();

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
        return winningPositions.checkWin(makeCopyOfGrid()).player();
    }

    private Player[] makeCopyOfGrid() {
        return grid.clone();
    }
}
