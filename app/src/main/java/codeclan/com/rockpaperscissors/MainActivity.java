package codeclan.com.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HandAdaptor handAdaptor = new HandAdaptor(this, Hand.values());

        ListView listView = findViewById(R.id.hand_buttons);
        listView.setAdapter(handAdaptor);
    }

    public void onHandButtonClick(View listHand) {
        Hand selectedHand = (Hand) listHand.getTag();
        Log.d("selected", selectedHand.toString());

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("playerHand", selectedHand);

        startActivity(intent);
    }
}
