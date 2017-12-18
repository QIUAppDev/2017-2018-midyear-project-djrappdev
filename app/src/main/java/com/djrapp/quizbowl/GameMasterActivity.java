package com.djrapp.quizbowl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameMasterActivity extends AppCompatActivity {

    TextView teamName, playerName, teamPoint;
    Button plusZero, plusTen, plusFifthteen, minusFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_master);

        teamName = findViewById(R.id.teamName);
        playerName = findViewById(R.id.playerName);
        teamPoint = findViewById(R.id.teamPoint);

        plusZero = findViewById(R.id.plusZero);
        plusTen = findViewById(R.id.plusTen);
        plusFifthteen = findViewById(R.id.plusFif);
        minusFive = findViewById(R.id.minusFive);

        plusZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        plusTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        plusFifthteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        minusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
