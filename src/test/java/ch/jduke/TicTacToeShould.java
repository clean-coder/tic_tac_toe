package ch.jduke;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeShould {

    @Test
    @DisplayName("""
            set 'x' as player when a new game is started
            """)
    public void newGame() {
        // arrange
        var expectedPlayer = "x";
        var ticTacToe = new TicTacToe();

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
        var ticTacToe = new TicTacToe();

        // act
        ticTacToe.mark();
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
        var ticTacToe = new TicTacToe();

        // act
        ticTacToe.mark();
        ticTacToe.mark();
        var actualPlayer = ticTacToe.getPlayer();

        // assert
        assertEquals(expectedPlayer, actualPlayer);
    }
}