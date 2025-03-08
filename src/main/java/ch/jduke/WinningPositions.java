package ch.jduke;

import java.util.List;

public class WinningPositions {
    private WinningPosition leftDiagonal = new WinningPosition(Position.TopLeft, Position.MiddleCenter, Position.BottomRight);
    private WinningPosition rightDiagonal = new WinningPosition(Position.TopRight, Position.MiddleCenter, Position.BottomLeft);
    private WinningPosition topRow =    new WinningPosition(Position.TopLeft,    Position.TopCenter,    Position.TopRight);
    private WinningPosition middleRow = new WinningPosition(Position.MiddleLeft, Position.MiddleCenter, Position.MiddleRight);
    private WinningPosition bottomRow = new WinningPosition(Position.BottomLeft, Position.BottomCenter, Position.BottomRight);

    private List<WinningPosition> allWinningPositions = List.of(
            leftDiagonal, rightDiagonal, topRow, middleRow, bottomRow
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
