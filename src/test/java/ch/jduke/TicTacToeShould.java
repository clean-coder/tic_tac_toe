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
        var TicTacToe = new TicTacToe();

        // act
        var actualPlayer = TicTacToe.getPlayer();

        // assert
        Assertions.assertEquals(actualPlayer, expectedPlayer);

    }
}