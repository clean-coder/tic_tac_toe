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
        var expectedPlayer = "x";

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
        var expectedPlayer = "o";

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
        var expectedPlayer = "x";

        // act
        ticTacToe.mark(Position.TopLeft);
        ticTacToe.mark(Position.TopLeft);
        var actualPlayer = ticTacToe.getPlayer();

        // assert
        assertEquals(expectedPlayer, actualPlayer);
    }
}