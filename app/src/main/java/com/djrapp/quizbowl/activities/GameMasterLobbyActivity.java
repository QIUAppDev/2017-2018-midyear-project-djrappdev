package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.room.Player;

import java.util.ArrayList;

public class GameMasterLobbyActivity extends AppCompatActivity{

    ScrollView players;
    Button startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gm_lobby);

        players = findViewById(R.id.players);
        startGame = findViewById(R.id.startGame);

        String username = getIntent().getStringExtra("Username");
        //Add to SQL
        startTimer();

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //JAMES NEEDS TO SET THE BINARY

                Intent masterIntent = new Intent(GameMasterLobbyActivity.this, GameMasterActivity.class);
                startActivity(masterIntent);
            }
        });
    }

    private void addPlayer(String name){
        TextView temp = new TextView(this);
        temp.setText(name);
        players.addView(temp);
    }

    void startTimer(){
        new CountDownTimer(4000,1000){
            public void onTick(long mill){
                update();
            }
            public void onFinish(){
                Log.d("Status","Done");
                startTimer();
            }
        }.start();
    }

    void update(){
        //Get the SQL table
        /*Remove Comments Later
        players.removeAllViews();
        ArrayList<Player> nameList  = aMethod();
        for(int i = 0; i < nameList.size(); i++){
            addPlayer(nameList.get(i).getUsername());
        }
        */
    }
}
