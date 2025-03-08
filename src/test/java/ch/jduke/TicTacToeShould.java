package ch.jduke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeShould {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    @DisplayName("""
            set 'x' as player when a new game is started
            """)
    public void newGame() {
        // arrange
        var expectedPlayer = Player.X;

        // act
        var actualPlayer = ticTacToe.getPlayer();

        // assert
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    @DisplayName("""
            set 'o' as player when 'x' has marked a field
            """)
    public void playerXMarkField() {
        // arrange
        var expectedPlayer = Player.O;

        // act
        ticTacToe.mark(Position.TopLeft);
        var actualPlayer = ticTacToe.getPlayer();

        // assert
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    @DisplayName("""
            check players alternate
            """)
    public void checkPlayersAlternate() {
        // arrange
        var expectedPlayer = Player.X;

        // act
        ticTacToe.mark(Position.TopLeft);
        ticTacToe.mark(Position.TopLeft);
        var actualPlayer = ticTacToe.getPlayer();

        // assert
        assertEquals(expectedPlayer, actualPlayer);
    }

    @DisplayName("""
            make win 'o' on left diagonal
            """)
    @Test
    public void oWinsLeftDiagonal() {
        // arrange
        var expectedWinner = Player.O;

        // act
        ticTacToe.mark(Position.TopCenter); // x
        ticTacToe.mark(Position.TopLeft); // o
        ticTacToe.mark(Position.BottomRight); // x
        ticTacToe.mark(Position.MiddleCenter); // o
        ticTacToe.mark(Position.BottomCenter); // x
        ticTacToe.mark(Position.BottomRight); // o

        var actualWinner = ticTacToe.getWinner();

        // assert
        assertEquals(expectedWinner, actualWinner);
    }


    @DisplayName("""
            make win 'o' on right diagonal
            """)
    @Test
    public void oWinsRightDiagonal() {
        // arrange
        var expectedWinner = Player.O;

        // act
        ticTacToe.mark(Position.TopCenter); // x
        ticTacToe.mark(Position.TopRight); // o
        ticTacToe.mark(Position.MiddleLeft); // x
        ticTacToe.mark(Position.MiddleCenter); // o
        ticTacToe.mark(Position.BottomCenter); // x
        ticTacToe.mark(Position.BottomLeft); // o

        var actualWinner = ticTacToe.getWinner();

        // assert
        assertEquals(expectedWinner, actualWinner);
    }

    @DisplayName("""
            make win 'o' on top row
            """)
    @Test
    public void oWinsTopRow() {
        // arrange
        var expectedWinner = Player.O;

        // act
        ticTacToe.mark(Position.MiddleLeft); // x
        ticTacToe.mark(Position.TopLeft); // o
        ticTacToe.mark(Position.MiddleCenter); // x
        ticTacToe.mark(Position.TopCenter); // o
        ticTacToe.mark(Position.BottomRight); // x
        ticTacToe.mark(Position.TopRight); // o

        var actualWinner = ticTacToe.getWinner();

        // assert
        assertEquals(expectedWinner, actualWinner);
    }

    @DisplayName("""
            make win 'o' on middle row
            """)
    @Test
    public void oWinsMiddleRow() {
        // arrange
        var expectedWinner = Player.O;

        // act
        ticTacToe.mark(Position.TopLeft); // x
        ticTacToe.mark(Position.MiddleLeft); // o
        ticTacToe.mark(Position.TopCenter); // x
        ticTacToe.mark(Position.MiddleCenter); // o
        ticTacToe.mark(Position.BottomRight); // x
        ticTacToe.mark(Position.MiddleRight); // o

        var actualWinner = ticTacToe.getWinner();

        // assert
        assertEquals(expectedWinner, actualWinner);
    }

    @DisplayName("""
            make win 'o' on bottom row
            """)
    @Test
    public void oWinsBottomRow() {
        // arrange
        var expectedWinner = Player.O;

        // act
        ticTacToe.mark(Position.TopCenter); // x
        ticTacToe.mark(Position.BottomLeft); // o
        ticTacToe.mark(Position.MiddleCenter); // x
        ticTacToe.mark(Position.BottomCenter); // o
        ticTacToe.mark(Position.MiddleRight); // x
        ticTacToe.mark(Position.BottomRight); // o

        var actualWinner = ticTacToe.getWinner();

        // assert
        assertEquals(expectedWinner, actualWinner);
    }

    @DisplayName("""
            make win 'none'
            """)
    @Test
    public void noneWins() {
        // arrange
        var expectedWinner = Player.None;

        // act
        ticTacToe.mark(Position.TopCenter); // x
        ticTacToe.mark(Position.TopLeft); // o
        ticTacToe.mark(Position.TopRight); // x
        ticTacToe.mark(Position.MiddleRight); // o
        ticTacToe.mark(Position.MiddleLeft); // x
        ticTacToe.mark(Position.BottomLeft); // o
        ticTacToe.mark(Position.MiddleCenter); // x
        ticTacToe.mark(Position.BottomCenter); // o
        ticTacToe.mark(Position.BottomRight); // x

        var actualWinner = ticTacToe.getWinner();

        // assert
        assertEquals(expectedWinner, actualWinner);
    }

    @DisplayName("""
            throws exception when position in grid is already marked
            """)
    @Test
    public void throwsExceptionWhenPositionInGridIsAlreadyMarked() {
        assertThrows(IllegalArgumentException.class, () -> {
            ticTacToe.mark(Position.TopCenter); // x
            ticTacToe.mark(Position.TopCenter); // o
        });
    }
}