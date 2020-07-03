package com.devslopes.herome.Fragments;

// useful: https://www.andreasschrade.com/android-native-fragment-or-support-fragment-or-androidx-fragment

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.devslopes.herome.Activities.MainActivity;
import com.devslopes.herome.R;

//import androidx.fragment.app.FragmentActivity;

public class MainFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button accidentBtn;
    private Button geneticBtn;
    private Button bornBtn;
    private Button chooseBtn;

    private MainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        accidentBtn = (Button)view.findViewById(R.id.accidentBtn);
        geneticBtn = (Button)view.findViewById(R.id.geneticBtn);
        bornBtn = (Button)view.findViewById(R.id.bornBtn);
        chooseBtn = (Button)view.findViewById(R.id.chooseBtn);

        accidentBtn.setOnClickListener(this);
        geneticBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);

        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadPickPowerScreen();
            }
        });

        chooseBtn.setEnabled(false);
        chooseBtn.getBackground().setAlpha(128);

        return view;
    }

    @Override
    public void onClick(View v) {
        chooseBtn.setEnabled(true);
        chooseBtn.getBackground().setAlpha(255);

        accidentBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        geneticBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,0,0);
        bornBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,0,0);

        Button btn = (Button)v;
        int leftDrawable = 0;

        if (btn == accidentBtn) {
            leftDrawable = R.drawable.lightning;
        } else if (btn == geneticBtn) {
            leftDrawable = R.drawable.atomic;
        } else if (btn == bornBtn) {
            leftDrawable = R.drawable.rocket;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.itemselected,0);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
