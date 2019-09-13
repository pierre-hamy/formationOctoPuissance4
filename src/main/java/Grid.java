import Exceptions.OutOfTockenException;

public class Grid {

    private static final int HAUTEUR = 6;
    private static final int LARGEUR = 7;

    private boolean isEmpty ;

    private Token[][] grid;

    public int[] getHighestTockenPositionForEachColumnList() {
        return highestTockenPositionForEachColumnList;
    }

    //TODO :A rendre génériqe en fonction de la largeur du puissance4
    private int[] highestTockenPositionForEachColumnList ;

    public Grid(){

        this.grid = new Token[LARGEUR][HAUTEUR];
        isEmpty = true;
        highestTockenPositionForEachColumnList = new int[]{0,0,0,0,0,0,0};

    }

    public Token[][] getGrid() {
        return grid;
    }

    public boolean is_empty(){

        return isEmpty ;
    }

    public void addTocken(Integer colonne, Token token) throws OutOfTockenException {

        if (highestTockenPositionForEachColumnList[colonne] == HAUTEUR) {
            throw new OutOfTockenException("More Tocken than possible in this column" , new Throwable());
        };
        highestTockenPositionForEachColumnList[colonne] += 1;

        this.grid[colonne][highestTockenPositionForEachColumnList[colonne]-1] = token ;
        isEmpty = false;

    }

}
