import java.util.Objects;

public class Analyser {

    private static final String ROUGE = "rouge";

    public Boolean has_winner(Grid grid) {

        if(grid.is_empty()) {
            return false;
        }
        boolean result = true;

        if (grid.getHighestTockenPositionForEachColumnList()[0] >= 4) {
            for (int ligne = 0; ligne < 4; ligne++) {
                if (!grid.getGrid()[0][ligne].getCouleur().equals(ROUGE)) {
                    result = false;
                }
            }
        }

    for (int column = 0; column < 3; column++) {
        //if (!grid.getGrid()[column][0].getCouleur().equals(ROUGE)) {
        if (!Objects.equals(grid.getGrid()[column][0].getCouleur(), ROUGE)) {
            result = false;
        }
    }

        return result;
    }
}
