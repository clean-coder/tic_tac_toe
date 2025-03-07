package ch.jduke;

import java.util.List;

public class WinningPositions {
    private WinningPosition leftDiagonal = new WinningPosition(Position.TopLeft, Position.MiddleCenter, Position.BottomRight);
    private WinningPosition rightDiagonal = new WinningPosition(Position.TopRight, Position.MiddleCenter, Position.BottomLeft);

    private List<WinningPosition> allWinningPositions = List.of(
            leftDiagonal, rightDiagonal
    );

    public WinningState checkWin(Player[] grid) {
        for (var winingPosition : allWinningPositions) {
            var winningState = winingPosition.check(grid);
            if (winningState.won()) {
                return winningState;
            }
        }
        return new WinningState(false, Player.None);
    }

}
