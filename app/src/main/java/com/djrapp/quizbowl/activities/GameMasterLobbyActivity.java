package com.djrapp.quizbowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.djrapp.quizbowl.R;

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

        addPlayer(username);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void addPlayer(String name){
        TextView temp = new TextView(this);
        temp.setText(name);
        players.addView(temp);
    }
}
