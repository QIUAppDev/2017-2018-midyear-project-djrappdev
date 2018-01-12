package com.djrapp.quizbowl.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.room.Player;

import java.util.ArrayList;

public class LobbyActivity extends AppCompatActivity {

    ScrollView players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        String username = getIntent().getStringExtra("Username");

        players = findViewById(R.id.players);
        //Add to SQL
        startTimer();

    }

    public Context getContext(){
        return LobbyActivity.this;
    }

    void addPlayer(String name) {
        TextView temp = new TextView(this);
        temp.setText(name);
        players.addView(temp);
    }

    void startTimer(){
        new CountDownTimer(4000,1000){
            public void onTick(long mill){
                update();
                /*
                if(state == 1){
                    new activity
                }
                */
            }
            public void onFinish(){
                Log.d("Status","Done");
                startTimer();
            }
        }.start();
    }

    void update(){
        //Get the SQL table
        players.removeAllViews();
        ArrayList<Player> nameList  = aMethod();
        for(int i = 0; i < nameList.size(); i++){
            addPlayer(nameList.get(i).getUsername());
        }
    }
}