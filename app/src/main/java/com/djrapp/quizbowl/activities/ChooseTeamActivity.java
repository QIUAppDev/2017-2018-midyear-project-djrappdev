package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.jsonrpc.QuizBowl;
import com.djrapp.quizbowl.room.Team;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ChooseTeamActivity extends AppCompatActivity {

    JsonRpcHttpClient client;
    Button createTeam, joinTeam;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText username;
    URL server;
    QuizBowl quizBowl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        createTeam = findViewById(R.id.createteam);
        joinTeam = findViewById(R.id.jointeam);
        radioGroup = findViewById(R.id.radioGroup);
        username = findViewById(R.id.username);

        //Sets quiz bowl server and connects to it
        try {
            server = new URL("http:///127.0.01/QuizBowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client = new JsonRpcHttpClient(server);
        quizBowl = ProxyUtil.createClientProxy(getClass().getClassLoader(), QuizBowl.class, client);

        updateRadioGroup("Lord Fifth");
        startTimer();

        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTeamActivity.this, CreateTeamActivity.class);
                startActivity(intent);
            }
        });
        joinTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                String teamName = radioButton.getText().toString(); //Will be used  in SQL
                String playerName = username.getText().toString();
                Intent intent = new Intent(ChooseTeamActivity.this, LobbyActivity.class);
                //intent.putExtra("Username",playerName);
                startActivity(intent);

            }
        });

    }

    //Add a team to the radio group. Should work...IN THeORY.
    private void updateRadioGroup(String name){
        radioGroup = findViewById(R.id.radioGroup);
        RadioButton rb = new RadioButton(getApplicationContext());
        rb.setText(name);
        rb.setTextColor(Color.BLACK);
        radioGroup.addView(rb);
    }


    void startTimer(){
        new CountDownTimer(5000,1000){
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
        /*Remove Comments Later
        radioGroup.removeAllViews();
        ArrayList<Team> teamList  = aMethod();
        for(int i = 0; i < teamList.size(); i++){
            updateRadioGroup(teamList.get(i).getName());
        }
        */
    }
}
