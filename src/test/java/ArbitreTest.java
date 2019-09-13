import Exceptions.OutOfTockenException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class ArbitreTest {

    @Test
    public void ChosenPlayerShouldReturnYellowPlayerWhenEmptyGrid () {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = new Grid();

        //when
        String nextPlayer = arbitre.getNextPlayer(grid);

        //Then
        assertEquals(nextPlayer,"YELLOW");

    }

    @Test
    public void ChosenPlayerShouldReturnRedPlayerOnSecondTurn () throws OutOfTockenException {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = new Grid();
        arbitre.play(grid, 1);

        //when
        String secondPlayer = arbitre.getNextPlayer(grid);

        //Then
        assertEquals(secondPlayer,"RED");

    }
    @Test
    public void ChosenPlayerShouldReturnRedPlayerOnThirdTurn () throws OutOfTockenException {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = new Grid();
        arbitre.play(grid, 1);
        arbitre.play(grid, 1);

        //when
        String thirdPlayer = arbitre.getNextPlayer(grid);

        //Then
        assertEquals(thirdPlayer,"YELLOW");

    }
    @Test
    public void PartyShouldBeRuningWhenEmptyGrid () {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = new Grid();
        //when
        Analyser analyser = new Analyser();
        Boolean endedParty = arbitre.isPartyEnded(grid, analyser);

        //Then
        assertFalse(endedParty);

    }

    @Test
    public void playShouldAddTocken () throws OutOfTockenException {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = mock(Grid.class);

        //when
        arbitre.play(grid,1);

        //Then
        verify(grid).addTocken(anyInt(), any(Token.class));

    }


    @Test
    public void PartyShouldBeEndedWhenAnalyserHasWinner () throws OutOfTockenException {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = new Grid();
       Analyser analyser = mock(Analyser.class);

        when(analyser.has_winner(grid)).thenReturn(Boolean.TRUE);

        //when
        Boolean endedParty = arbitre.isPartyEnded(grid,analyser);


        //Then
        assertTrue(endedParty);

    }


    @Test
    public void PartyShouldNotBeEndedWhenAnalyserHasNoWinner () throws OutOfTockenException {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = new Grid();
        Analyser analyser = mock(Analyser.class);

        when(analyser.has_winner(grid)).thenReturn(Boolean.FALSE);

        //when
        Boolean endedParty = arbitre.isPartyEnded(grid,analyser);


        //Then
        assertFalse(endedParty);

    }

    @Test
    public void ArbitreShouldReturnYellowWhenYelloWon ()  throws OutOfTockenException {
        //given
        Arbitre arbitre = new Arbitre();
        Grid grid = new Grid();
        Analyser analyser = mock(Analyser.class);

        when(analyser.getWinner(grid)).thenReturn("YELLOW");

        //when
        String winner = arbitre.getWinner(grid,analyser);


        //Then
        assertEquals(endedParty);

    }
}
