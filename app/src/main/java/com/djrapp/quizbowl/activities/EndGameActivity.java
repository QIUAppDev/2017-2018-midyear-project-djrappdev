package com.djrapp.quizbowl.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.djrapp.quizbowl.R;
import com.djrapp.quizbowl.jsonrpc.QuizBowl;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

import java.net.MalformedURLException;
import java.net.URL;

public class EndGameActivity extends AppCompatActivity{

    ScrollView scrollScores;
    Button exit;
    JsonRpcHttpClient client;
    URL server;
    QuizBowl quizBowl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        scrollScores = findViewById(R.id.scores);
        exit = findViewById(R.id.exit);

        try {
            server = new URL("http://10.42.0.1:8080/quizbowl.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client = new JsonRpcHttpClient(server);
        quizBowl = ProxyUtil.createClientProxy(getClass().getClassLoader(), QuizBowl.class, client);

        /*
        List<Team> teamList = quizBowl.getTeams();
        for(int i = 0; i < teamList.size(); i++){
            addTeamPoints(teamList.get(i).getName() + " - " + teamList.get(i).getScore() + " points");
        }
        */
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    void addTeamPoints(String name) {
        TextView temp = new TextView(this);
        temp.setText(name);
        scrollScores.addView(temp);
    }
}
