package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.jsonrpc.QuizBowl;
import com.djrapp.quizbowl.room.Player;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class LobbyActivity extends AppCompatActivity {

    ScrollView players;
    String username, teamName;
    Button playBt;
    JsonRpcHttpClient client;
    URL server;
    QuizBowl quizBowl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        username = getIntent().getStringExtra("Username");
        teamName = getIntent().getStringExtra("TeamName");
        playBt.findViewById(R.id.play);
        players = findViewById(R.id.players);

        //Add to SQL//Sets quiz bowl server and connects to it
        try {
            server = new URL("http:///127.0.01/QuizBowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client = new JsonRpcHttpClient(server);
        quizBowl = ProxyUtil.createClientProxy(getClass().getClassLoader(), QuizBowl.class, client);

        //quizBowl.addUser(username, teamName, 0);
        //startTimer();

        players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LobbyActivity.this, ActiveGameActivity.class);
                startActivity(intent);
            }
        });

    }

    void addPlayer(String name) {
        TextView temp = new TextView(this);
        temp.setText(name);
        players.addView(temp);
    }

    void startTimer(){
        new CountDownTimer(4000,1000){
            public void onTick(long mill){
                update();
                if(quizBowl.getLobbyState() == 1){
                    Intent intent = new Intent(LobbyActivity.this, ActiveGameActivity.class);
                    intent.putExtra("Username",username);
                    intent.putExtra("TeamName",teamName);
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
        //Get the SQL table
        players.removeAllViews();
        List<Player> nameList = quizBowl.getPlayers();
        for(int i = 0; i < nameList.size(); i++){
            addPlayer(nameList.get(i).getUsername());
        }
    }
}