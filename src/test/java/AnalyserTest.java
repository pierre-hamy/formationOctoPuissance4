import Exceptions.OutOfTockenException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalyserTest {


    @Test
    public void has_winner_should_return_false_when_empty_grid() {
        //given
        Analyser analyser = new Analyser();
        Grid grid = new Grid();

        //when
        boolean has_winner = analyser.has_winner(grid);

        //then
        assertFalse(has_winner);
    }

    @Test
    public void winner_should_return_winner_when_4_continuous_tokens_in_column_0() throws OutOfTockenException {
        //given
        Analyser analyser = new Analyser();
        Grid grid = new Grid();

        grid.addTocken(0, new Token("rouge"));
        grid.addTocken(0, new Token("rouge"));
        grid.addTocken(0, new Token("rouge"));
        grid.addTocken(0, new Token("rouge"));

        //when
        boolean has_winner = analyser.has_winner(grid);

        //then
        assertTrue(has_winner);
    }
    @Test
    public void winner_should_return_no_winner_when_4_NON_continuous_tokens_in_column_0() throws OutOfTockenException {
        //given
        Analyser analyser = new Analyser();
        Grid grid = new Grid();

        grid.addTocken(0, new Token("rouge"));
        grid.addTocken(0, new Token("jaune"));
        grid.addTocken(0, new Token("rouge"));
        grid.addTocken(0, new Token("jaune"));

        //when
        boolean has_winner = analyser.has_winner(grid);

        //then
        assertFalse(has_winner);
    }

//    @Test
//    public void winner_should_return_winner_when_4__continuous_tokens_in_line() throws OutOfTockenException {
//        //given
//        Analyser analyser = new Analyser();
//        Grid grid = new Grid();
//
//        grid.addTocken(0, new Token("rouge"));
//        grid.addTocken(1, new Token("rouge"));
//        grid.addTocken(2, new Token("rouge"));
//        grid.addTocken(3, new Token("rouge"));
//
//        //when
//        boolean has_winner = analyser.has_winner(grid);
//
//        //then
//        assertTrue(has_winner);
//    }
}