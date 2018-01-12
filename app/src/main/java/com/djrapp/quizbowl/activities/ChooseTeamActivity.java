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
import com.djrapp.quizbowl.room.Team;

import java.util.ArrayList;

public class ChooseTeamActivity extends AppCompatActivity {

    Button createTeam, joinTeam;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        createTeam = findViewById(R.id.createteam);
        joinTeam = findViewById(R.id.jointeam);
        radioGroup = findViewById(R.id.radioGroup);
        username = findViewById(R.id.username);

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
                intent.putExtra("Username",playerName);
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
        radioGroup.removeAllViews();
        ArrayList<Team> teamList  = aMethod();
        for(int i = 0; i < teamList.size(); i++){
            updateRadioGroup(teamList.get(i).getName());
        }
    }
}
