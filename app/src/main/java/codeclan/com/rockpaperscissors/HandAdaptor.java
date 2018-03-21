package codeclan.com.rockpaperscissors;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by user on 21/03/2018.
 */

public class HandAdaptor extends ArrayAdapter<Hand>{

    public HandAdaptor(Context context, Hand[] hands) {
        super(context, 0, hands);
    }

    @Override
    public View getView(int position, View buttonListView, ViewGroup parent) {

        Hand currentHand = getItem(position);

        if(buttonListView == null) {
            buttonListView = LayoutInflater.from(getContext()).inflate(R.layout.hand_button, parent, false);
        }

        Button button = buttonListView.findViewById(R.id.hand_button);
        button.setText(currentHand.toString());

//        Log.d("test", currentHand.toString());

        button.setTag(currentHand);

//        Log.d("tagis", buttonListView.getTag().toString());

        return buttonListView;
    }

}
