package ch.jduke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}