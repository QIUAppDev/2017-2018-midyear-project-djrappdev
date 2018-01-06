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

public class CreateTeamActivity extends AppCompatActivity{

    EditText teamName;
    Button createTeam;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

        createTeam = findViewById(R.id.createteam);
        teamName = findViewById(R.id.teamName);

        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = teamName.getText().toString(); //Join with SQL table
                updateRadioGroup(name);
                Intent intent = new Intent(CreateTeamActivity.this, LobbyActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateRadioGroup(String name){
        radioGroup = findViewById(R.id.radioGroup);
        RadioButton rb = new RadioButton(getApplicationContext());
        rb.setText(name);
        rb.setTextColor(Color.BLACK);
        radioGroup.addView(rb);
    }
}
