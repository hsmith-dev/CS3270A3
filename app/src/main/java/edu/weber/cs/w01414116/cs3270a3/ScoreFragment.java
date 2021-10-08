package edu.weber.cs.w01414116.cs3270a3;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private View root;
    private int count = 0;
    private onButtonListener mCallback;

    public interface onButtonListener{
        void fragButtonPressed(Button btn);
    }

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btn = root.findViewById(R.id.btnPaper);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //call actions needed

                // needs to pass through that paper was selected back to main activity,
                // within the main activity it will then tell the fragment for the phone to
                // select it's choice, pass it back to the main activity and the main activity
                // will pass choices to the winner fragment to determine and display the winner,
                // where it will then pass the count of the winner into the related count fragment
                mCallback.fragButtonPressed(btn);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);

        try{
            mCallback = (onButtonListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "Must implement onButtonListener()");
        }
    }
}