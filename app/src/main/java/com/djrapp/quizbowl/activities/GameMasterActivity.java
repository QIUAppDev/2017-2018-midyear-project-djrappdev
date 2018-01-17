package com.djrapp.quizbowl.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.jsonrpc.QuizBowl;
import com.djrapp.quizbowl.room.Player;
import com.djrapp.quizbowl.room.Team;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GameMasterActivity extends AppCompatActivity {

    JsonRpcHttpClient client;
    URL server;
    QuizBowl quizBowl;
    private TextView teamName, playerName, teamPoint, timer;
    private Button plusZero, plusTen, plusFifteenth, minusFive, exit;
    private boolean onBuzz = false;
    private Player currentPlayer;
    private Team currentTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_master);

        try {
            server = new URL("http://10.42.0.1:8080/quizbowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client = new JsonRpcHttpClient(server);
        quizBowl = ProxyUtil.createClientProxy(getClass().getClassLoader(), QuizBowl.class, client);


        teamName = findViewById(R.id.teamName);
        playerName = findViewById(R.id.playerName);
        teamPoint = findViewById(R.id.teamPoint);
        timer = findViewById(R.id.timer);

        plusZero = findViewById(R.id.plusZero);
        plusTen = findViewById(R.id.plusTen);
        plusFifteenth = findViewById(R.id.plusFif);
        minusFive = findViewById(R.id.minusFive);
        exit = findViewById(R.id.exit);


        plusZero.setEnabled(false);
        plusTen.setEnabled(false);
        plusFifteenth.setEnabled(false);
        minusFive.setEnabled(false);

        if(onBuzz == false) {
            startTimer();
        }

        plusZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //currentTeam.setScore(currentTeam.getScore() + 0);
                //currentPlayer.setScore(currentPlayer.getScore() + 0);
                quizBowl.addPoints(0,currentPlayer);
                quizBowl.clearBuzz();
                onBuzz = false;

                plusZero.setEnabled(false);
                plusTen.setEnabled(false);
                plusFifteenth.setEnabled(false);
                minusFive.setEnabled(false);

                startTimer();
            }
        });
        plusTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBowl.addPoints(10,currentPlayer);
                quizBowl.clearBuzz();
                onBuzz = false;

                plusZero.setEnabled(false);
                plusTen.setEnabled(false);
                plusFifteenth.setEnabled(false);
                minusFive.setEnabled(false);

                startTimer();
            }
        });
        plusFifteenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBowl.addPoints(15,currentPlayer);
                quizBowl.clearBuzz();
                onBuzz = false;

                plusZero.setEnabled(false);
                plusTen.setEnabled(false);
                plusFifteenth.setEnabled(false);
                minusFive.setEnabled(false);

                startTimer();
            }
        });
        minusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBowl.addPoints(-5,currentPlayer);
                quizBowl.clearBuzz();
                onBuzz = false;

                plusZero.setEnabled(false);
                plusTen.setEnabled(false);
                plusFifteenth.setEnabled(false);
                minusFive.setEnabled(false);

                startTimer();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GameMasterActivity.this);
                builder.setMessage("Are you sure you want to exit?");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }
                );
                builder.setNegativeButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                quizBowl.setEndState();
                                Intent intent = new Intent(getApplicationContext(), EndGameActivity.class);
                                startActivity(intent);
                            }
                        }
                );
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    void startCountDown(){
        new CountDownTimer(5000,1000){
            public void onTick(long mill){
                timer.setText(mill/1000 + "");
            }
            public void onFinish(){
                timer.setText("Time!");
            }
        }.start();
    }

    void startTimer(){
        new CountDownTimer(1000,1000){
            public void onTick(long mill){
                update();
            }
            public void onFinish(){
                Log.d("Status","Done");
                if(onBuzz == false){
                    startTimer();
                }
            }
        }.start();
    }

    void update(){
        if(quizBowl.checkBuzz() == 1){
            onBuzz = true;
            currentPlayer = quizBowl.getWhoBuzzed();
            ArrayList<Team> teamList = quizBowl.getTeams();
            for(int i = 0; i< teamList.size(); i++){
                if(teamList.get(i).getName().equals(currentPlayer.getTeamId())){
                    currentTeam = teamList.get(i);
                    teamPoint.setText("Points: " + teamList.get(i).getScore());
                }
            }
            playerName.setText("Player Name: "+ currentPlayer.getUsername());
            teamName.setText("Team Name: " + currentPlayer.getTeamId());

            plusZero.setEnabled(true);
            plusTen.setEnabled(true);
            plusFifteenth.setEnabled(true);
            minusFive.setEnabled(true);

            startCountDown();
        }
    }

}
