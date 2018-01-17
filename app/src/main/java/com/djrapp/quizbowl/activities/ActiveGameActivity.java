package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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

public class ActiveGameActivity extends AppCompatActivity {

    JsonRpcHttpClient client;
    URL server;
    QuizBowl quizBowl;
    private TextView teamPoints, yourPoints;
    private ImageButton buzzerButton;
    private Player player;
    private Team team;
    private String username, teamname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_game);

        teamPoints = findViewById(R.id.teamPointsID);
        yourPoints = findViewById(R.id.yourPointsID);
        buzzerButton = findViewById(R.id.buzzerID);

        username = getIntent().getStringExtra("Username");
        teamname = getIntent().getStringExtra("TeamName");

        //Add to SQL//Sets quiz bowl server and connects to it
        try {
            server = new URL("http://10.42.0.1:8080/quizbowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client = new JsonRpcHttpClient(server);
        quizBowl = ProxyUtil.createClientProxy(getClass().getClassLoader(), QuizBowl.class, client);

        ArrayList<Team> teamList = quizBowl.getTeams();
        for(int i = 0; i < teamList.size(); i++){
            if(teamList.get(i).getName().equals(teamname)){
                team = teamList.get(i);
            }
        }

        ArrayList<Player> playerList = quizBowl.getPlayers();
        for(int i = 0; i < playerList.size(); i++){
            if(playerList.get(i).getUsername().equals(username)){
                player = playerList.get(i);
            }
        }

        startTimer();

        buzzerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send a response to the GM
                quizBowl.buzz(player);
            }
        });
    }

    void startTimer(){
        new CountDownTimer(4000,1000){
            public void onTick(long mill){
                update();
                if(quizBowl.getEndState() == 1){
                    Intent intent = new Intent(ActiveGameActivity.this, EndGameActivity.class);
                    startActivity(intent);
                }
            }
            public void onFinish(){
                Log.d("Status","Done");
                startTimer();
            }
        }.start();
    }

    void update(){
        teamPoints.setText("Team Points: " + team.getScore());
        yourPoints.setText("Your Points: " + player.getScore());
    }
}
