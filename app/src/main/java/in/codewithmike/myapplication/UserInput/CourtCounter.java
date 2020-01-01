package in.codewithmike.myapplication.UserInput;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import in.codewithmike.myapplication.R;
import in.codewithmike.myapplication.utils.Tools;

public class CourtCounter extends AppCompatActivity {

    private int scoreTeamA = 0, scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_counter);

        initToolbar(); // instantiating toolbar

    }

    private void initToolbar() {
        ImageView backArrowButton = findViewById(R.id.backArrowButton);
        TextView headerTextView = findViewById(R.id.headerTextView);
        headerTextView.setText("User Input : Court Counter App");
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Tools.setSystemBarColorInt(this, Color.parseColor("#FFFFFF"));
    }

    /*Increase the score for Team A by 1 point.*/
    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /* Increase the score for Team A by 2 points.*/
    public void addTwoForTeamA(View v) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /*Increase the score for Team A by 3 points.*/
    public void addThreeForTeamA(View v) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    /*Increase the score for Team B by 1 point.*/
    public void addOneForTeamB(View v) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    /* Increase the score for Team B by 2 points.*/
    public void addTwoForTeamB(View v) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    /*Increase the score for Team B by 3 points.*/
    public void addThreeForTeamB(View v) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /*Reset score for TeamA and TeamB*/
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /* Displays the given score for Team A.*/
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /* Displays the given score for Team B.*/
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
