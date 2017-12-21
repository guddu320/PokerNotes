package com.example.godwin.pokernotes;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowNotes extends Fragment
{
    View view;
    TextView details;
    // Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_show_notes, container, false);
        details = (TextView)view.findViewById(R.id.textView_showNotes);
        Bundle args = getArguments();
        args.getString("info");

        details.setText(args.toString());
        return view;
    }


}