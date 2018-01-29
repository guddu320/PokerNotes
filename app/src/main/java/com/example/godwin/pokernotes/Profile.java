package com.example.godwin.pokernotes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends Fragment {

    EditText username, password, rePassword;
    Button saveProfile, cancelProfile;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        view = inflater.inflate(R.layout.activity_profile, container, false);

        username = (EditText) view.findViewById(R.id.editText_Username);
        password = (EditText) view.findViewById(R.id.editText_Password);
        rePassword = (EditText) view.findViewById(R.id.editText_RePassword);
        saveProfile = (Button) view.findViewById(R.id.button_SaveProfile);
        cancelProfile = (Button) view.findViewById(R.id.button_CancelProfile);

        String user = username.getText().toString();
        String pass = password.getText().toString();
        String rpass = rePassword.getText().toString();


        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText()!=null && username.getText()!=null && password.getText().toString().equals(rePassword.getText().toString())){
                    SharedPreferences sharedPref = getActivity().getSharedPreferences("Profile",0);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString( "Username", username.getText().toString());
                    editor.putString( "Password", password.getText().toString());
                    editor.commit();
                    Toast.makeText(getActivity().getApplicationContext(), "Profile saved", Toast.LENGTH_LONG).show();

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    HomeFragment home = new HomeFragment();
                    fragmentTransaction.replace(R.id.frameLayout,home,"Home");
                    fragmentTransaction.commit();
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                }

            }
        });

        cancelProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        return view;
    }

}
