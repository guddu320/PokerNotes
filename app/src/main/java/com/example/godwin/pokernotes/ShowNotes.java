package com.example.godwin.pokernotes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class ShowNotes extends Fragment
{
    View view;
    TextView details;
    Button back;
    // Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_show_notes, container, false);
        details = (TextView)view.findViewById(R.id.textView_showNotes);
        Bundle bundle = getArguments();
        final String text = bundle.getString("Info");
        Log.e(TAG, text.substring(24,32) );
        details.setText(text);

        back = (Button)view.findViewById(R.id.button_backToPlayer);
        back.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v) {
                                           if(text.substring(24,32).equals("Player 1")){
                                               Player1 player1 = new Player1();
                                               FragmentManager fm = getFragmentManager();
                                               // create a FragmentTransaction to begin the transaction and replace the Fragment
                                               FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                               // replace the FrameLayout with new Fragment
                                               fragmentTransaction.replace(R.id.frameLayout, player1, "1");
                                               fragmentTransaction.commit(); // save the changes
                                           }

                                           else if(text.substring(24,32).equals("Player 2")){
                                               Player2 player2 = new Player2();
                                               FragmentManager fm = getFragmentManager();
                                               // create a FragmentTransaction to begin the transaction and replace the Fragment
                                               FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                               // replace the FrameLayout with new Fragment
                                               fragmentTransaction.replace(R.id.frameLayout, player2, "2");
                                               fragmentTransaction.commit(); // save the changes
                                           }

                                       }
                                   }
        );
        return view;
    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }


}