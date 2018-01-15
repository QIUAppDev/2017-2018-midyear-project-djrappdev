package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.jsonrpc.QuizBowl;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateTeamActivity extends AppCompatActivity{

    EditText teamName;
    Button createTeam;
    RadioGroup radioGroup;
    JsonRpcHttpClient client;
    URL server;
    QuizBowl quizBowl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

        createTeam = findViewById(R.id.createTeam);
        teamName = findViewById(R.id.teamName);

        //Final modifier might cause issues
        final String nameP = getIntent().getStringExtra("Username");

        //Sets quiz bowl server and connects to it
        try {
            server = new URL("http://localhost:8080/quizbowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client = new JsonRpcHttpClient(server);
        quizBowl = ProxyUtil.createClientProxy(getClass().getClassLoader(), QuizBowl.class, client);


        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameT = teamName.getText().toString();
                //Pass team name to SQL
                quizBowl.addTeam(nameT);
                Intent intent = new Intent(CreateTeamActivity.this, LobbyActivity.class);
                intent.putExtra("Username", nameP);
                intent.putExtra("TeamName", nameT);
                startActivity(intent);
            }
        });
    }
}
