package com.example.week6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        button = findViewById(R.id.fragButtn);



        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

    }

    private void sendMessage() {


        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment = manager.findFragmentById(R.id.fragment);


        if(fragment instanceof Fragment1){


            ((Fragment1) fragment).tv.setText(" Message from Activity to Fragment 1 ");

        }
        else
        {
            if( fragment instanceof Fragment2){
                ((Fragment2) fragment).displayMessage(" Hi there ");
            }

        }


    }


    int val = 0;

    public void replaceFragment(View view) {


        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();


        Fragment2 fragment2 = new Fragment2();
        Fragment1 fragment1 = new Fragment1();

        if (val%2 == 0) {
            transaction.add(R.id.fragment, fragment2);
        }
        else{

            transaction.add(R.id.fragment, fragment1);

        }

        val += 1;

        transaction.commit();




    }
}