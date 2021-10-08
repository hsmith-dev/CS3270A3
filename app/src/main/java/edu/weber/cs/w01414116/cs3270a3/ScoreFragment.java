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
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private View root;
    private onButtonListener mCallBack;
    private TextView tvGame, tvPhone, tvWin, tvTie;


    public interface onButtonListener{
        void fragBtnResetPressed();
    }

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        tvGame = root.findViewById(R.id.tvGamePlayedScore);
        tvPhone = root.findViewById(R.id.tvPhoneScore);
        tvWin = root.findViewById(R.id.tvMyWinScore);
        tvTie = root.findViewById(R.id.tvTieScore);

        Button btnReset = root.findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                updateText(0,0,0,0);
                // displays toast message showing the scores have been reset
                Toast toast = Toast.makeText(getActivity(), "Counts are reset", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void updateText(int count, int pCount, int mCount, int tCount){
        tvGame.setText(""+count);
        tvPhone.setText(""+pCount);
        tvWin.setText(""+mCount);
        tvTie.setText(""+tCount);
    }

    // instructor says to ignore the deprecations since we are targeting API 21
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        try{
            mCallBack = (ScoreFragment.onButtonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " Must implement onButtonListener()");
        }
    }


}