package com.djrapp.quizbowl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChooseTeamActivity extends AppCompatActivity {

    Button createTeam, joinTeam;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team);

        createTeam = findViewById(R.id.createteam);
        joinTeam = findViewById(R.id.jointeam);
        radioGroup = findViewById(R.id.radioGroup);

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
                Intent intent = new Intent(ChooseTeamActivity.this, LobbyActivity.class);
                startActivity(intent);
            }
        });

    }
}
