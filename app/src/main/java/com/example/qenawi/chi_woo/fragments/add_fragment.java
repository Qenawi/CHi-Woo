package com.example.qenawi.chi_woo.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qenawi.chi_woo.DATA_BASE.Contract;
import com.example.qenawi.chi_woo.DATA_BASE.DATA_BASE_1;
import com.example.qenawi.chi_woo.DATA_BASE.DP_item;
import com.example.qenawi.chi_woo.Drop_list_adap;
import com.example.qenawi.chi_woo.R;

import java.util.Arrays;
import java.util.List;

public class add_fragment extends android.support.v4.app.Fragment {
    Spinner Sp, Sp2, Sp3;
    DATA_BASE_1 dp;//create Dp
    Button save;
    List<String> Lines;
    EditText e1, e2, e3;
    Drop_list_adap adap;
    DP_item dp_item;
    private OnFragmentInteractionListener mListener;
    public add_fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        dp = new DATA_BASE_1(getContext(), Contract.Dp_name, null, 2);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_add_fragment, container, false);
        // inishlize spiners lize spiners
        Sp = (Spinner) root.findViewById(R.id.Spiner_Shirt);
        Sp2 = (Spinner) root.findViewById(R.id.Spiner_pantalon);
        Sp3 = (Spinner) root.findViewById(R.id.Spiner_DAZMA);
        e1 = (EditText) root.findViewById(R.id.edit_text_shirt);
        e2 = (EditText) root.findViewById(R.id.pantalon_des);
        e3 = (EditText) root.findViewById(R.id.DAZMA_des);
        save = (Button) root.findViewById(R.id.save_btn);
        ///-----------------------------------------------------------------
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View root= view;
        Lines = Arrays.asList(getResources().getStringArray(R.array.colors_names));
        adap=new Drop_list_adap(getActivity(),R.layout.list_item,R.id.text23,Lines);
// Fill with data

        //     ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),R.layout.list_item, items);
        Sp.setAdapter(adap);
        Sp2.setAdapter(adap);
        Sp3.setAdapter(adap);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = 0;
                if (!e1.getText().toString().equals("description")) {
                    dp_item = new DP_item();
                    dp_item.setType(Contract.Item_type1);
                    dp_item.setColor(Sp.getSelectedItem().toString());
                    dp_item.setDescreption(e1.getText().toString());
                    dp.insert(dp_item);
                    flag = 1;
                }
                if (!e2.getText().toString().equals("description")) {
                    flag = 1;
                    dp_item = new DP_item();
                    dp_item.setType(Contract.Item_type2);
                    dp_item.setColor(Sp2.getSelectedItem().toString());
                    dp_item.setDescreption(e2.getText().toString());
                    dp.insert(dp_item);
                }
                if (!e3.getText().toString().equals("description")) {
                    flag = 1;
                    dp_item = new DP_item();
                    dp_item.setType(Contract.Item_type3);
                    dp_item.setColor(Sp3.getSelectedItem().toString());
                    dp_item.setDescreption(e3.getText().toString());
                    dp.insert(dp_item);
                }
                //---------------------------------------------------
                if (1 == flag) {
                    dp.close();
                } else {
                    Toast.makeText(getActivity(), "NO_thing_to_save", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void on_ACTIOM(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}