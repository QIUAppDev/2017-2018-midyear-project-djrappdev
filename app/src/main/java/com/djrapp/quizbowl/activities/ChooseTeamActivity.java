package com.djrapp.quizbowl.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
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
import com.djrapp.quizbowl.room.Team;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ChooseTeamActivity extends AppCompatActivity {
    Button createTeam, joinTeam;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText username;

    URL url;
    JSONRPC2Session quizbowl;
    JSONRPC2Response response;
    int requestID = 1;
    JSONRPC2Request request;

    List<Team> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        createTeam = findViewById(R.id.createteam);
        joinTeam = findViewById(R.id.jointeam);
        radioGroup = findViewById(R.id.radioGroup);
        username = findViewById(R.id.username);

        //Sets quiz bowl server URL and
        try {
            url = new URL("http://10.42.0.1:8080/quizbowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        quizbowl = new JSONRPC2Session(url);
        request = new JSONRPC2Request("getLobbyState", requestID);
        //new JsonTask().execute();
        //username.setText((String)response.getResult());
        //startTimer();

        updateRadioGroup("Lord Fifth");

        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseTeamActivity.this, CreateTeamActivity.class);
                String playerName = username.getText().toString();
                intent.putExtra("Username", playerName);
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
                intent.putExtra("Username", playerName);
                startActivity(intent);

            }
        });

    }

    //Add a team to the radio group
    private void updateRadioGroup(String name) {
        radioGroup = findViewById(R.id.radioGroup);
        RadioButton rb = new RadioButton(getApplicationContext());
        rb.setText(name);
        rb.setTextColor(Color.BLACK);
        radioGroup.addView(rb);
    }


    void startTimer() {
        new CountDownTimer(5000, 1000) {
            public void onTick(long mill) {
                update();
            }

            public void onFinish() {
                Log.d("Status", "Done");
                startTimer();
            }
        }.start();
    }

    void update() {
        //Get the SQL table
        radioGroup.removeAllViews();
        for (int i = 0; i < teamList.size(); i++) {
            updateRadioGroup(teamList.get(i).getName());
        }
    }

    public void setResponse(JSONRPC2Response response) {
        this.response = response;
    }

    private class JsonTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... url) {
            //teamList = quizBowl.getTeams();
            try {
                setResponse(quizbowl.send(request));
            } catch (JSONRPC2SessionException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}