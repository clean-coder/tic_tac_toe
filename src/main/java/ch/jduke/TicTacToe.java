package ch.jduke;

public class TicTacToe {
    private String actualPlayer = "x";

    public String getPlayer() {
        return actualPlayer;
    }

    public void mark() {
        if (actualPlayer.equals("x")) {
            actualPlayer = "o";
            return;
        }
        actualPlayer = "x";
    }
}
