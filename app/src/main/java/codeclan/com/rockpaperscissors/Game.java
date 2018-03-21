package codeclan.com.rockpaperscissors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by user on 21/03/2018.
 */

public class Game {

    private Player player;
    private Player computer;
    private HashMap<Hand, ArrayList<Hand>> solutions;

    public Game() {
        player = new Player();
        computer = new Player();
        solutions = new HashMap<>();
        ArrayList<Hand> rockLosesTo = new ArrayList<>();
        rockLosesTo.add(Hand.SPOCK);
        rockLosesTo.add(Hand.PAPER);

        ArrayList<Hand> paperLosesTo = new ArrayList<>();
        paperLosesTo.add(Hand.SCISSORS);
        paperLosesTo.add(Hand.LIZARD);

        ArrayList<Hand> scissorsLosesTo = new ArrayList<>();
        scissorsLosesTo.add(Hand.ROCK);
        scissorsLosesTo.add(Hand.SPOCK);

        ArrayList<Hand> lizardLosesTo = new ArrayList<>();
        lizardLosesTo.add(Hand.SCISSORS);
        lizardLosesTo.add(Hand.ROCK);

        ArrayList<Hand> spockLosesTo = new ArrayList<>();
        spockLosesTo.add(Hand.PAPER);
        spockLosesTo.add(Hand.LIZARD);


        solutions.put(Hand.ROCK, rockLosesTo);
        solutions.put(Hand.PAPER, paperLosesTo);
        solutions.put(Hand.SCISSORS, scissorsLosesTo);
        solutions.put(Hand.LIZARD, lizardLosesTo);
        solutions.put(Hand.SPOCK, spockLosesTo);
    }


    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }

    public Player checkWinner() {
        if (player.getHand() == computer.getHand()) {
            return null;
        }
        else if (this.solutions.get(player.getHand()).contains(computer.getHand())) {
            computer.increaseScore();
            return computer;
        }
        else {
            player.increaseScore();
           return player;
        }

    }

    public void setComputerHand() {
        Random random = new Random();
        int index = random.nextInt(Hand.values().length);

        Hand hand = Hand.values()[index];
        computer.setHand(hand);
    }



}
