package ch.jduke;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(actualPlayer, expectedPlayer);
    }
}