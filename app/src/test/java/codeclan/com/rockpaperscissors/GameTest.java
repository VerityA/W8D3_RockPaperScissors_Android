package codeclan.com.rockpaperscissors;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 21/03/2018.
 */

public class GameTest {

    Game game;

    @Before
    public void before() {
        game = new Game();

    }

    @Test
    public void canCompareHandsPlayerWins() {
        Player player = game.getPlayer();
        player.setHand(Hand.PAPER);
        Player computer = game.getComputer();
        computer.setHand(Hand.ROCK);
        assertEquals(player, game.checkWinner());
    }

    @Test
    public void canCompareHandsDraw() {
        Player player = game.getPlayer();
        player.setHand(Hand.PAPER);
        Player computer = game.getComputer();
        computer.setHand(Hand.PAPER);
        assertEquals(null, game.checkWinner());
    }

    @Test
    public void canSetRandomComputerHand() {
        game.setComputerHand();
        System.out.println(game.getComputer().getHand());
    }
}
