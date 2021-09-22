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
 * Use the {@link BtnFragPaper#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BtnFragPaper extends Fragment {

    private View root;
    private int count = 0;
    private onButtonListener mCallback;

    public interface onButtonListener{
        void fragButtonPressed(int count);
    }

    public BtnFragPaper() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_btn_paper, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btn = root.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                mCallback.fragButtonPressed(count);
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