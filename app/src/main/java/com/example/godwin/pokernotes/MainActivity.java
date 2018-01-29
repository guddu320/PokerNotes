package com.example.godwin.pokernotes;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    Button Player1, Player2, Player3, Player4, Player5, Next, Prev, Back;
    Storage myDb = new Storage(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player1 = (Button) findViewById(R.id.button_player1);
        Player2 = (Button) findViewById(R.id.button_player2);
        Player3 = (Button) findViewById(R.id.button_player3);
        Player4 = (Button) findViewById(R.id.button_player4);
        Player5 = (Button) findViewById(R.id.button_player5);


        Player1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           // load First Fragment
                                           FragmentManager fm = getFragmentManager();
                                           // create a FragmentTransaction to begin the transaction and replace the Fragment
                                           FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                           // replace the FrameLayout with new Fragment
                                           Player1 player1 = new Player1();
                                           fragmentTransaction.replace(R.id.frameLayout, player1, "1");
                                           fragmentTransaction.commit(); // save the changes
                                       }
                                   }
        );
        Player2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           // load First Fragment
                                           FragmentManager fm = getFragmentManager();
                                           // create a FragmentTransaction to begin the transaction and replace the Fragment
                                           FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                           // replace the FrameLayout with new Fragment
                                           Player2 player2 = new Player2();
                                           fragmentTransaction.replace(R.id.frameLayout, player2, "2");
                                           fragmentTransaction.commit(); // save the changes
                                       }
                                   }
        );
        Player3.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           // load First Fragment
                                           FragmentManager fm = getFragmentManager();
                                           // create a FragmentTransaction to begin the transaction and replace the Fragment
                                           FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                           // replace the FrameLayout with new Fragment
                                           Player3 player3 = new Player3();
                                           fragmentTransaction.replace(R.id.frameLayout, player3, "3");
                                           fragmentTransaction.commit(); // save the changes
                                       }
                                   }
        );
        Player4.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           // load First Fragment
                                           FragmentManager fm = getFragmentManager();
                                           // create a FragmentTransaction to begin the transaction and replace the Fragment
                                           FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                           // replace the FrameLayout with new Fragment
                                           Player4 player4 = new Player4();
                                           fragmentTransaction.replace(R.id.frameLayout, player4, "4");
                                           fragmentTransaction.commit(); // save the changes
                                       }
                                   }
        );
        Player5.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           // load First Fragment
                                           FragmentManager fm = getFragmentManager();
                                           // create a FragmentTransaction to begin the transaction and replace the Fragment
                                           FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                           // replace the FrameLayout with new Fragment
                                           Player5 player5 = new Player5();
                                           fragmentTransaction.replace(R.id.frameLayout, player5, "5");
                                           fragmentTransaction.commit(); // save the changes
                                       }
                                   }
        );


        Next = (Button) findViewById(R.id.button_next);
        Prev = (Button) findViewById(R.id.button_previous);
        Next.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Player1 myFragment1 = (Player1) getFragmentManager().findFragmentByTag("1");
                                        Player2 myFragment2 = (Player2) getFragmentManager().findFragmentByTag("2");
                                        Player3 myFragment3 = (Player3) getFragmentManager().findFragmentByTag("3");
                                        Player4 myFragment4 = (Player4) getFragmentManager().findFragmentByTag("4");
                                        Player5 myFragment5 = (Player5) getFragmentManager().findFragmentByTag("5");
                                        if (myFragment1 != null && myFragment1.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player2 player2 = new Player2();
                                            fragmentTransaction.replace(R.id.frameLayout, player2, "2");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                        else if (myFragment2 != null && myFragment2.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player3 player3 = new Player3();
                                            fragmentTransaction.replace(R.id.frameLayout, player3, "3");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                        else if (myFragment3 != null && myFragment3.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player4 player4 = new Player4();
                                            fragmentTransaction.replace(R.id.frameLayout, player4, "4");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                        else if (myFragment4 != null && myFragment4.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player5 player5 = new Player5();
                                            fragmentTransaction.replace(R.id.frameLayout, player5, "5");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                        else if (myFragment5 != null && myFragment5.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player1 player1 = new Player1();
                                            fragmentTransaction.replace(R.id.frameLayout, player1, "1");
                                            fragmentTransaction.commit(); // save the changes
                                        }
                                        else {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player1 player1 = new Player1();
                                            fragmentTransaction.replace(R.id.frameLayout, player1, "1");
                                            fragmentTransaction.commit();
                                        }
                                    }
                                }
        );

        Prev.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Player1 myFragment1 = (Player1) getFragmentManager().findFragmentByTag("1");
                                        Player2 myFragment2 = (Player2) getFragmentManager().findFragmentByTag("2");
                                        Player3 myFragment3 = (Player3) getFragmentManager().findFragmentByTag("3");
                                        Player4 myFragment4 = (Player4) getFragmentManager().findFragmentByTag("4");
                                        Player5 myFragment5 = (Player5) getFragmentManager().findFragmentByTag("5");
                                        if (myFragment1 != null && myFragment1.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player5 player5 = new Player5();
                                            fragmentTransaction.replace(R.id.frameLayout, player5, "5");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                       else if (myFragment2 != null && myFragment2.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player1 player1 = new Player1();
                                            fragmentTransaction.replace(R.id.frameLayout, player1, "1");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                       else if (myFragment3 != null && myFragment3.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player2 player2 = new Player2();
                                            fragmentTransaction.replace(R.id.frameLayout, player2, "2");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                       else if (myFragment4 != null && myFragment4.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player3 player3 = new Player3();
                                            fragmentTransaction.replace(R.id.frameLayout, player3, "3");
                                            fragmentTransaction.commit(); // save the changes
                                        }

                                       else if (myFragment5 != null && myFragment5.isVisible()) {
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player4 player4 = new Player4();
                                            fragmentTransaction.replace(R.id.frameLayout, player4, "4");
                                            fragmentTransaction.commit(); // save the changes
                                        }
                                        else{
                                            FragmentManager fm = getFragmentManager();
                                            // create a FragmentTransaction to begin the transaction and replace the Fragment
                                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                                            // replace the FrameLayout with new Fragment
                                            Player5 player5 = new Player5();
                                            fragmentTransaction.replace(R.id.frameLayout, player5, "5");
                                            fragmentTransaction.commit();
                                        }

                                    }
                                }
        );

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.saveEntry) {
            Storage myDb = new Storage(this);
            myDb.deleteAllRecords();
            return true;
        } else if (id == R.id.sendEntry) {

            AlertDialog.Builder altDial= new AlertDialog.Builder(MainActivity.this);
            altDial.setMessage("Do you wish to send?").setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Storage myDb = new Storage(getApplicationContext());
                            sendEmail();
                            myDb.deleteAllRecords();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = altDial.create();
            alert.setTitle("Alert!");
            alert.show();
            return true;
        } else if (id == R.id.profile){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            Profile p = new Profile();
            fragmentTransaction.replace(R.id.frameLayout, p);
            fragmentTransaction.commit();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(View view){
        Back = (Button)findViewById(R.id.button_back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder altDial= new AlertDialog.Builder(MainActivity.this);
                altDial.setMessage("Do you wish to save?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = altDial.create();
                alert.setTitle("Alert!");
                alert.show();

            }
        });
    }

    public void onHomeClick(View view){
        HomeFragment home = new HomeFragment();
        if(!home.isVisible()){

            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,home,"Home");
            fragmentTransaction.commit();
        }

    }

    protected void sendEmail() {
        String[] TO = {"godwinsamuel320@gmail.com"};
        String[] CC = {""};

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Profile", 0);
        String user = pref.getString("Username",null);

        Cursor res = myDb.getAllData();
        String content = new String();
        while (res.moveToNext()) {
                content += res.getString(2) + ",\t ";
                content += res.getString(3) + ",\t";
                content += res.getString(4) + "\n";
                content += res.getString(5) + "\n\n";
        }

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Player log");
        emailIntent.putExtra(Intent.EXTRA_TEXT, user + "\n\n" + content);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
