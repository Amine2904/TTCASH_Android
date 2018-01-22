package fr.utt.if26.ttcash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton jouer, quitter, score;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        databaseHelper = new DatabaseHelper(this);

        if (intent.hasExtra("Name") && intent.hasExtra("Prename") && intent.hasExtra("Score")) {
            String name = intent.getStringExtra("Name") + " " + intent.getStringExtra("Prename");
            int score = intent.getIntExtra("Score", 0);
            AddData(name, score);
        }

        score = (ImageButton) findViewById(R.id.score);
        jouer = (ImageButton) findViewById(R.id.jouer);
        quitter = (ImageButton) findViewById(R.id.quitter);

        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(GameActivity.class);
            }
        });
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIntent(ScoreActivity.class);
            }
        });
    }

    private void setIntent(Class className) {
        Intent intent = new Intent(MainActivity.this, className);
        startActivity(intent);
    }

    private void AddData(String playerName, int score) {
        boolean insertData = databaseHelper.addData(playerName, score);
        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
