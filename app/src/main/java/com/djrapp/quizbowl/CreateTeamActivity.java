package com.djrapp.quizbowl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateTeamActivity extends AppCompatActivity {

    EditText teamName;
    Button createTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_team);

        createTeam = findViewById(R.id.createteam);
        teamName = findViewById(R.id.teamName);

        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateTeamActivity.this, LobbyActivity.class);
                startActivity(intent);
            }
        });
    }
}
