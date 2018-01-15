package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.jsonrpc.QuizBowl;
import com.djrapp.quizbowl.room.Player;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GameMasterLobbyActivity extends AppCompatActivity{

    JsonRpcHttpClient client;
    ScrollView players;
    Button startGame;
    URL server;
    QuizBowl quizBowl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gm_lobby);

        players = findViewById(R.id.players);
        startGame = findViewById(R.id.startGame);

        try {
            server = new URL("http://localhost:8080/quizbowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client = new JsonRpcHttpClient(server);
        quizBowl = ProxyUtil.createClientProxy(getClass().getClassLoader(), QuizBowl.class, client);

        String username = getIntent().getStringExtra("Username");
        quizBowl.addUser(username, "GameMaster", 1);
        startTimer();

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBowl.setLobbyState();
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
        players.removeAllViews();
        ArrayList<Player> nameList  = quizBowl.getPlayers();
        for(int i = 0; i < nameList.size(); i++){
            addPlayer(nameList.get(i).getUsername());
        }
    }
}
