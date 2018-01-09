package com.djrapp.quizbowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import com.djrapp.quizbowl.R;

public class LobbyActivity extends AppCompatActivity {

    ScrollView players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        String username = getIntent().getStringExtra("Username");

        players = findViewById(R.id.players);

        addPlayer(username);

    }

    private void addPlayer(String name){
        TextView temp = new TextView(this);
        temp.setText(name);
        players.addView(temp);
    }
}
