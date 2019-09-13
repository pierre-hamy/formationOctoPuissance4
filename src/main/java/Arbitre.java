import Exceptions.OutOfTockenException;

public class Arbitre {

    String nextPlayer = "YELLOW";

    public String getNextPlayer(Grid grid) {
        return nextPlayer;
    }
    public void play(Grid grid, int column) throws OutOfTockenException {
        switch (nextPlayer) {
            case  "YELLOW": nextPlayer = "RED"; break;
            case  "RED": nextPlayer = "YELLOW"; break;
        }

        grid.addTocken(column, new Token(nextPlayer));
    }

    public Boolean isPartyEnded(Grid grid, Analyser analyser) {

        return analyser.has_winner(grid);
    }


//    public String Winner(Grid)
}
