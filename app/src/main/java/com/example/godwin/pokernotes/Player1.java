package com.example.godwin.pokernotes;

import android.app.AlertDialog;
import android.app.Fragment;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Player1 extends Fragment {
    View view;
    TextView day, date, time;
    Button save, viewDetails;
    EditText entry;
    Storage myDb;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_player1, container, false);
        myDb = new Storage(getActivity());

        day = (TextView) view.findViewById(R.id.textView_Day);
        date = (TextView) view.findViewById(R.id.textView_date);
        time = (TextView) view.findViewById(R.id.textView_time);
        entry = (EditText) view.findViewById(R.id.editText_entry);

        Calendar calendar = Calendar.getInstance();
        int x = calendar.get(Calendar.DAY_OF_WEEK);

        switch (x) {
            case Calendar.SUNDAY:
                day.setText("Sunday");
                break;

            case Calendar.MONDAY:
                day.setText("Monday");
                break;

            case Calendar.TUESDAY:
                day.setText("Tuesday");
                break;

            case Calendar.WEDNESDAY:
                day.setText("Wednesday");
                break;

            case Calendar.THURSDAY:
                day.setText("Thursday");
                break;

            case Calendar.FRIDAY:
                day.setText("Friday");
                break;

            case Calendar.SATURDAY:
                day.setText("Saturday");
                break;
        }

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(calendar.getTime());
        date.setText(formattedDate);
        String formattedTime = Calendar.HOUR_OF_DAY + ": " + calendar.get(Calendar.MINUTE);
        if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
            formattedTime = formattedTime + " PM";
        } else {
            formattedTime = formattedTime + " AM";
        }
        time.setText(formattedTime);

        save = (Button) view.findViewById(R.id.button_save1);
        viewDetails = (Button) view.findViewById(R.id.button_view1);
        AddData();
        viewAll();

        return view;
    }

    public void AddData() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = myDb.insertData("Player 1", day.getText().toString(), date.getText().toString(), time.getText().toString(), entry.getText().toString());
                if (isInserted == true)
                    Toast.makeText(getActivity().getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAll() {
        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Entry number :" + res.getString(0) + "\n");
                    buffer.append("Player :" + res.getString(1) + "\n");
                    buffer.append("Day :" + res.getString(2) + "\n");
                    buffer.append("Date :" + res.getString(3) + "\n");
                    buffer.append("Time :" + res.getInt(4) + "\n");
                    buffer.append("Notes :" + res.getInt(5) + "\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}

