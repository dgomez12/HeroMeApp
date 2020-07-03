package com.devslopes.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

import com.devslopes.herome.Activities.MainActivity;
import com.devslopes.herome.R;

public class PickPowerFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webSlicingBtn;
    private Button laserVisionBtn;
    private Button strengthBtn;
    private Button backstoryBtn;

    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);

        turtleBtn = (Button)view.findViewById(R.id.turtlePowerBtn);
        lightningBtn = (Button) view.findViewById(R.id.lightningBtn);
        flightBtn = (Button) view.findViewById(R.id.flightBtn);
        webSlicingBtn = (Button) view.findViewById(R.id.webSlicingBtn);
        laserVisionBtn = (Button) view.findViewById(R.id.laserVisionBtn);
        strengthBtn = (Button) view.findViewById(R.id.superStrengthBtn);
        backstoryBtn = (Button) view.findViewById(R.id.showBackstoryBtn);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webSlicingBtn.setOnClickListener(this);
        laserVisionBtn.setOnClickListener(this);
        strengthBtn.setOnClickListener(this);

        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtlepower,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thorshammer,0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.supermancrest,0,0,0);
        webSlicingBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb,0,0,0);
        laserVisionBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laservision,0,0,0);
        strengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superstrength,0,0,0);

        Button btn = (Button)v;
        int leftDrawable = 0;

        if (btn == turtleBtn) {
            leftDrawable = R.drawable.turtlepower;
        } else if (btn == lightningBtn) {
            leftDrawable = R.drawable.thorshammer;
        } else if (btn == flightBtn) {
            leftDrawable = R.drawable.supermancrest;
        } else if (btn == webSlicingBtn) {
            leftDrawable = R.drawable.spiderweb;
        } else if (btn == laserVisionBtn) {
            leftDrawable = R.drawable.laservision;
        } else if (btn == strengthBtn) {
            leftDrawable = R.drawable.superstrength;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.itemselected,0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
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

    public interface PickPowerInteractionListener {
        void onPickPowerFragmentInteraction(Uri uri);
    }
}
