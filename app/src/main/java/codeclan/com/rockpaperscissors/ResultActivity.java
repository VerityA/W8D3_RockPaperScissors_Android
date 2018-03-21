package codeclan.com.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent intent = getIntent();
        Hand playerHand = (Hand) intent.getSerializableExtra("playerHand");

        Log.d("test", playerHand.toString());

        Game game = new Game();

        game.getPlayer().setHand(playerHand);
        game.setComputerHand();

        Hand computerHand = game.getComputer().getHand();

        Player winner = game.checkWinner();

        String message;

        if (winner == game.getPlayer()) {
            message = "You win!";
        }
        else if ( winner == null) {
                message = "It's a draw";
        }
        else {
                message = "Sorry, computer wins...";
        }


        TextView playersHand = findViewById(R.id.player_hand);
        playersHand.setText(playerHand.toString());

        TextView computersHand = findViewById(R.id.computer_hand);
        computersHand.setText(computerHand.toString());

        TextView winningPlayer = findViewById(R.id.winner);
        winningPlayer.setText(message);

        TextView playerScore = findViewById(R.id.player_score);
        Integer plScore = game.getPlayer().getScore();
        playerScore.setText(plScore.toString());

        TextView computerScore = findViewById(R.id.computer_score);
        Integer score = game.getComputer().getScore();
        computerScore.setText(score.toString());



    }

    public void onPlayButtonClick(View clickView) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }


}
