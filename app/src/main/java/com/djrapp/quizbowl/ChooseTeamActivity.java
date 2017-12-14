package com.djrapp.quizbowl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class ChooseTeamActivity extends AppCompatActivity {

    Button createTeam, joinTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        createTeam = findViewById(R.id.createteam);
        joinTeam = findViewById(R.id.jointeam);

    }
}
