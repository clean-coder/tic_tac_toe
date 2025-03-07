package ch.jduke;

public class TicTacToe {
    private String actualPlayer = "x";

    public String getPlayer() {
        return actualPlayer;
    }

    public void mark() {
        actualPlayer = actualPlayer.equals("x") ? "o" : "x";
    }
}
