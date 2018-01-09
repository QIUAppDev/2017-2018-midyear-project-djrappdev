package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.djrapp.quizbowl.R;

public class CreateGameActivity extends AppCompatActivity {

    EditText gameName, gameUserName;
    Button createGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        gameName = findViewById(R.id.gameName);
        gameUserName = findViewById(R.id.gameUserName);
        createGame = findViewById(R.id.createGame);

        createGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = gameUserName.getText().toString();
                Intent intent = new Intent(CreateGameActivity.this, GameMasterLobbyActivity.class);
                intent.putExtra("Username", playerName);
                startActivity(intent);
            }
        });
    }

}
