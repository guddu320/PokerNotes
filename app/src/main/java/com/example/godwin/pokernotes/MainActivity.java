package com.example.godwin.pokernotes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Player1, Player2, Player3, Player4, Player5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player1 = (Button) findViewById(R.id.button_player1);

        Player1.setOnClickListener(new View.OnClickListener()
                                         {
                                             @Override
                                             public void onClick(View v) {
                                                 // load First Fragment
                                                 loadFragment(new Player1());
                                             }
                                         }
        );
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOpionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.saveEntry) {
        Storage myDb = new Storage(this);
        myDb.deleteAllRecords();
        return true;
        } else if (id == R.id.sendEntry) {
            Storage myDb = new Storage(this);
            myDb.deleteAllRecords();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
