package com.djrapp.quizbowl;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameMasterActivity extends AppCompatActivity {

    TextView teamName, playerName, teamPoint;
    Button plusZero, plusTen, plusFifthteenth, minusFive, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_master);

        teamName = findViewById(R.id.teamName);
        playerName = findViewById(R.id.playerName);
        teamPoint = findViewById(R.id.teamPoint);

        plusZero = findViewById(R.id.plusZero);
        plusTen = findViewById(R.id.plusTen);
        plusFifthteenth = findViewById(R.id.plusFif);
        minusFive = findViewById(R.id.minusFive);
        exit = findViewById(R.id.exit);

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
        plusFifthteenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        minusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GameMasterActivity.this);
                builder.setMessage("Are you sure you want to exit?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                System.exit(0);
                            }
                        }
                );
                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }
                );
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

}
