package fr.utt.if26.ttcash;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewDebug;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView firstPlayer, secondPlayer, thirdPlayer, fourthPlayer, fifthPlayer,
            firstScore, secondScore, thirdScore, fourthScore, fifthScore;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        firstPlayer = (TextView) findViewById(R.id.firstPlayer);
        secondPlayer = (TextView) findViewById(R.id.secondPlayer);
        thirdPlayer = (TextView) findViewById(R.id.thirdPlayer);
        fourthPlayer = (TextView) findViewById(R.id.fourthPlayer);
        fifthPlayer = (TextView) findViewById(R.id.fifthPlayer);
        firstScore = (TextView) findViewById(R.id.firstScore);
        secondScore = (TextView) findViewById(R.id.secondScore);
        thirdScore = (TextView) findViewById(R.id.thirdScore);
        fourthScore = (TextView) findViewById(R.id.fourthScore);
        fifthScore = (TextView) findViewById(R.id.fifthScore);

        databaseHelper = new DatabaseHelper(this);

        ViewData();
    }

    private void ViewData() {

        Cursor data = databaseHelper.getData();
        int index = 0;
        while (data.moveToNext()) {
            String name = data.getString(1);
            int score = data.getInt(2);

            switch (index) {
                case 0:
                    firstPlayer.setText(name);
                    firstScore.setText(String.valueOf(score));
                    break;
                case 1:
                    secondPlayer.setText(name);
                    secondScore.setText(String.valueOf(score));
                    break;
                case 2:
                    thirdPlayer.setText(name);
                    thirdScore.setText(String.valueOf(score));
                    break;
                case 3:
                    fourthPlayer.setText(name);
                    fourthScore.setText(String.valueOf(score));
                    break;
                case 4:
                    fifthPlayer.setText(name);
                    fifthScore.setText(String.valueOf(score));
                    break;
            }

            index++;
        }
    }
}
