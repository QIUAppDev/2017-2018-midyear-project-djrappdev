package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.djrapp.quizbowl.R;


public class MainActivity extends AppCompatActivity{

    private Button createRoom;
    private Button joinRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        createRoom = findViewById(R.id.create);
        joinRoom = findViewById(R.id.join);

        createRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateGameActivity.class);
                startActivity(intent);
            }
        });
        joinRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseTeamActivity.class);
                startActivity(intent);
            }
        });
    }
}
