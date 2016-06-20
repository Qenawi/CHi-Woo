package com.example.qenawi.chi_woo.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qenawi.chi_woo.ASync_TASK_LisTner1;
import com.example.qenawi.chi_woo.ASync_Task_2;
import com.example.qenawi.chi_woo.DATA_BASE.Contract;
import com.example.qenawi.chi_woo.DATA_BASE.DATA_BASE_1;
import com.example.qenawi.chi_woo.R;
import com.example.qenawi.chi_woo.read_Dp;

import java.util.ArrayList;

public class suit_me_fragment extends android.support.v4.app.Fragment implements ASync_TASK_LisTner1 {
    ArrayList<String> Shirts, pants, Dezm, Comp;// ineed to fill this
    private OnFragmentInteractionListener mListener;
    private read_Dp A;
    ProgressBar ProgressBar;
    private ASync_Task_2 C;
    DATA_BASE_1 dp;
    Button p1, p2;
    TextView t1, t2, t3, t4, t5, t6;
    int Counter;
    public void lunch_Async(String new_state, int tag)// pop or top
    {
        A = new read_Dp(this);// listners is hocked up
        A.execute(new_state, tag, dp);
    }

    public void create_comp(int tag)// pop or top
    {
        C = new ASync_Task_2(this);// listners is hocked up
        C.execute(tag, Shirts, pants, Dezm);
    }

    public suit_me_fragment()
    {
        // Required empty public constructor
    }

    public void GET_next_Ta2m()
    {
ArrayList<String>Tisla=new ArrayList<>();
        if(Comp.size()<=Counter){Toast.makeText(getActivity(),"OUT_OF_RANGE",Toast.LENGTH_SHORT).show();return;}
        String Tmp=Comp.get(Counter);
        String Ops="";
        for(int i=0,k=0;i<Tmp.length();i++)
        {
            if(Tmp.charAt(i) =='\n'|| Tmp.charAt(i)==',' )
            {

                Tisla.add(Ops);
                k+=1;
                Ops="";
                continue;
            }
            Ops+=Tmp.charAt(i);
        }

        t1.setText(Tisla.get(0));
        t2.setText(Tisla.get(1));
        t3.setText(Tisla.get(2));
        t4.setText(Tisla.get(3));
        t5.setText(Tisla.get(4));
        t6.setText(Tisla.get(5));
        Counter += 1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        dp = new DATA_BASE_1(getContext(), Contract.Dp_name, null, 2);// create instance of Dp
        Counter = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.suit_me_fragment, container, false);
        lunch_Async(Contract.Item_type1, 0);//give me 4irts
        lunch_Async(Contract.Item_type2, 1);//        pants
        lunch_Async(Contract.Item_type3, 2);//        dZmes

        p1 = (Button) root.findViewById(R.id.next);
        p2 = (Button) root.findViewById(R.id.chose);
        t1 = (TextView) root.findViewById(R.id.shirt_des);
        t2 = (TextView) root.findViewById(R.id.shirt_clr);
        t3 = (TextView) root.findViewById(R.id.pants_des);
        t4 = (TextView) root.findViewById(R.id.pants_clr);
        t5 = (TextView) root.findViewById(R.id.dzma_des);
        t6 = (TextView) root.findViewById(R.id.dzma_clr);
        ProgressBar=(ProgressBar)root.findViewById(R.id.progressBar);

        ProgressBar.setVisibility(View.VISIBLE);
        //->

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GET_next_Ta2m();
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Chosen", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void on_ACTIOM(Uri uri) {
        if (mListener != null) {
            mListener.suit_me_listner(uri);
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

    @Override
    public void onTaskComplete(Object result, int tag) {
        if (tag == 0) {
            Shirts = (ArrayList<String>) result;
            Log.v("Shirts", Shirts.size() + "  . 1");

        }
        if (tag == 1) {
            pants = (ArrayList<String>) result;
            Log.v("Pants", pants.size() + "  . 2");

        }
        if (tag == 2) {//evry thing is fetched
            Dezm = (ArrayList<String>) result;
            Log.v("DEzm", Dezm.size() + "  . 3");
            create_comp(3);

            //-> lunch async task to create patterns
        }
        if (tag == 3) {
            Comp = (ArrayList<String>) result;
            Log.v("Comp_Sz", Comp.size() + "  . 4");
            ProgressBar.setVisibility(View.GONE);
            GET_next_Ta2m();

        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void suit_me_listner(Uri uri);
    }

}
