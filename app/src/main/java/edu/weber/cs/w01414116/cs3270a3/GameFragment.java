package edu.weber.cs.w01414116.cs3270a3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    private View root;
    private onButtonListener mCallBack; // m stands for member
    private int count = 0, pCount = 0, mCount = 0, tCount = 0;
    private TextView tvPhonePick, tvWinner;

    public interface onButtonListener {
        void fragButtonPressed(int count, int pCount, int mCount, int tCount);
    }

    public GameFragment() {
        // Required empty public constructor


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // creates buttons and sets the reference to the buttons
        Button btnRock = root.findViewById(R.id.btnRock);
        Button btnPaper = root.findViewById(R.id.btnPaper);
        Button btnScissors = root.findViewById(R.id.btnScissors);

        btnRock.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // count increments the number of games played
                count++;
                onUserChoice('r');
            }
        });

        // this is the listener for the paper button
        btnPaper.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // count increments the number of games played
                count++;
                onUserChoice('p');
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // count increments the number of games played
                count++;
                onUserChoice('s');
            }
        });

        tvPhonePick = root.findViewById(R.id.tvPhonePick);
        tvWinner = root.findViewById(R.id.tvWinner);
    }

    // instructor says to ignore the deprecations since we are targeting API 21
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        try{
            mCallBack = (onButtonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " Must implement onButtonListener()");
        }
    }

    /**
     *
     * @param uChoice the character that represents rock, paper or scissors that the user selected
     */
    private void onUserChoice(char uChoice){
        // pChoice is used as the phone's choice
        char pChoice = computeChoice();
        // determines who wins the game, or if a tie, then calls another method to update text
        gameRules(uChoice, pChoice);
    }

    private char computeChoice(){
        char choice;

        Random rand = new Random();
        int intChoice = rand.nextInt(3);
        if(intChoice == 0)
            choice = 'r';
        else if(intChoice == 1)
            choice = 'p';
        else
            choice = 's';

        return choice;
    }

    private void gameRules(char uChoice, char pChoice){
        if (uChoice == 'r'){
            if(pChoice == 'r'){
                //tie
                tCount++;
                updateGameText("Rock","Tie!");
            } else if(pChoice == 'p'){
                // phone wins
                pCount++;
                updateGameText("Paper","Phone Wins!");
            } else if(pChoice == 's'){
                // user wins
                mCount++;
                updateGameText("Scissors","You Win!");
            }
        } else if (uChoice == 'p'){
            if(pChoice == 'r'){
                // user wins
                mCount++;
                updateGameText("Rock","You Win!");
            } else if(pChoice == 'p'){
                // tie
                tCount++;
                updateGameText("Paper","Tie!");
            } else if(pChoice == 's'){
                // phone wins
                pCount++;
                updateGameText("Scissors","Phone Wins!");
            }
        } else if (uChoice == 's'){
            if(pChoice == 'r'){
                // phone wins
                pCount++;
                updateGameText("Rock","Phone Wins!");
            } else if(pChoice == 'p'){
                // user wins
                mCount++;
                updateGameText("Paper","You Win!");
            } else if(pChoice == 's'){
                // tie
                tCount++;
                updateGameText("Scissors","Tie!");
            }
        }
    }

    private void updateGameText(String phone, String result){
        tvPhonePick.setText(""+phone);
        tvWinner.setText(result+"");
    }

    // used to reset the counts
    protected void resetCounts(){
        count = 0;
        pCount = 0;
        mCount = 0;
        tCount = 0;
    }
}