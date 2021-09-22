package edu.weber.cs.w01414116.cs3270a3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TxtFragTieGames extends Fragment {

    private View root;
    private TextView tv;

    public TxtFragTieGames() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_txt_frag_tie_games, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        tv = root.findViewById(R.id.txtFragPhoneWinCnt);
    }

    public void updateText(int count){
        tv.setText("Tie Games " + count);
    }
}