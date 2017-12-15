package com.djrapp.quizbowl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

public class LobbyActivity extends AppCompatActivity {

    ScrollView players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        players = findViewById(R.id.players);

    }
}
