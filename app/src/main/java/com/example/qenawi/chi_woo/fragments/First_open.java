package com.example.qenawi.chi_woo.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.qenawi.chi_woo.DATA_BASE.Contract;
import com.example.qenawi.chi_woo.DATA_BASE.DATA_BASE_1;
import com.example.qenawi.chi_woo.R;

public class First_open extends android.support.v4.app.Fragment {
    Button p1,p2,p3;
    DATA_BASE_1 dp;//create Dp
    private OnFragmentInteractionListener mListener;
    // TODO: Rename and change types and number of parameters

    public First_open() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_first_open, container, false);

        p1=(Button)root.findViewById(R.id.ADD);
        p2=(Button)root.findViewById(R.id.Sut_me);
        p3=(Button)root.findViewById(R.id.Drop);

        p1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
           mListener.Call_Frag(0);
            }
        });

        p2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mListener.Call_Frag(1);
            }
        });
        p3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dp = new DATA_BASE_1(getContext(), Contract.Dp_name, null, 2);
                dp.Drop();
            }
        });




        return  root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void on_ACTIOM(Uri uri)
    {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public void Call_Frag(int id);
    }

}
