package edu.weber.cs.w01414116.cs3270a3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class TxtFragMyWinCnt extends Fragment {

    private View root;
    private TextView tv;

    public TxtFragMyWinCnt() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_txt_frag_my_win_cnt, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        tv = root.findViewById(R.id.txtFragMyWinCnt);
    }

    public void updateText(int count){
        tv.setText("My Win Count " + count);
    }

}