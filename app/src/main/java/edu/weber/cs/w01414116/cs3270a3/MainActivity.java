package edu.weber.cs.w01414116.cs3270a3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GameFragment.onButtonListener, ScoreFragment.onButtonListener{

    private GameFragment gameFragment;
    private ScoreFragment scoreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // from GameFragment.onButtonListener, receives communication from another fragment
    // should be for sending info to fragmentScoreView / fragment_score.xml
    @Override
    public void fragButtonPressed(int count, int pCount, int mCount, int tCount) {

        if (scoreFragment == null) {
            FragmentManager fm = getSupportFragmentManager();
            scoreFragment = (ScoreFragment) fm.findFragmentById(R.id.fragmentScoreView);
        }

        scoreFragment.updateText(count, pCount, mCount, tCount);
    }

    @Override
    public void fragBtnResetPressed() {
        if (gameFragment == null) {
            FragmentManager fm = getSupportFragmentManager();
            gameFragment = (GameFragment) fm.findFragmentById(R.id.fragmentGameView);
        }
        // resets counts within the game
        gameFragment.resetCounts();
    }
}