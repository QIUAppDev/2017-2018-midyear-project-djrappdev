package com.djrapp.quizbowl;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActiveGameActivity extends AppCompatActivity {

    TextView status;
    ImageButton buzzer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_game);

        status.findViewById(R.id.status);
        buzzer.findViewById(R.id.buzzer);

        buzzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
