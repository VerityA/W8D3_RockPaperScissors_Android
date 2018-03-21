package codeclan.com.rockpaperscissors;

/**
 * Created by user on 21/03/2018.
 */

public class Player {

    private Hand hand;
    private int score;

    public Player() {
        this.hand = hand;
        this.score = 0;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score += 1;
    }
}
