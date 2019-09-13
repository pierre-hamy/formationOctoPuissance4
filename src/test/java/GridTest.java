import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Exceptions.OutOfTockenException;

class GridTest {




    @Test
    void it_should_initialize_grid() {

        //given
        Grid grid = new Grid();
        Token[][] expectedGrid = new Token[7][6];

        //when
        Token[][] gridResult = grid.getGrid();

        // then = assert
        assertArrayEquals (expectedGrid, gridResult);
    }

    @Test
    void it_should_add_inserted_token() throws OutOfTockenException {

        //given
        Grid grid = new Grid();
        Token token = new Token("rouge");

        //when
        grid.addTocken(1, token);

        // then = assert
        assertEquals (grid.getGrid()[1][0], token);
    }


    @Test
    void it_should_check_if_Tocken_not_added_in_unexpected_column() throws OutOfTockenException {

        //given
        Grid grid = new Grid();
        Token token = new Token("rouge");


        //when
        grid.addTocken(2, token);

        // then = assert
        assertNotEquals( grid.getGrid()[0][0], token);
    }

    @Test
    void it_should_return_empty_grill_when_created() {
        //given
        Grid gridvide = new Grid();

        //when
        boolean isEmpty = gridvide.is_empty();

        // then = assert
        assert isEmpty;
    }
    @Test
    void it_should_not_be_empty_when_tocken_already_inserted() throws OutOfTockenException {
        //given
        Grid emptyGrid = new Grid();
        emptyGrid.addTocken(1,new Token("rouge"));

        //when
        boolean isEmpty = emptyGrid.is_empty();

        // then = assert
        assertFalse(isEmpty);
    }
    @Test
    void SecondAddedTockenShouldBeAboveThefirstOne () throws OutOfTockenException {
        //given
        Grid grid = new Grid();

        //when
        grid.addTocken(1,new Token("rouge"));

        Token token = new Token("rouge");
        grid.addTocken(1, token);

        // then = assert
        assertEquals( grid.getGrid()[1][1], token);
    }
    @Test
    void CanInsert6TokensIn1Column () throws OutOfTockenException {
        //given
        Grid grid = new Grid();

        //when
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        Token token = new Token("rouge");
        grid.addTocken(3, token);

        // then = assert
        assertEquals( grid.getGrid()[3][5], token);
    }
    @Test
    void MoreTokensThanExpectedInAColumnShouldRiseAnOutOfTockenException () throws OutOfTockenException {
        //given
        Grid grid = new Grid();

        //when
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));
        grid.addTocken(3,new Token("rouge"));

        // then = assert
        assertThrows(OutOfTockenException.class,() -> {
            grid.addTocken(3,new Token("rouge"));
        });
    }

}