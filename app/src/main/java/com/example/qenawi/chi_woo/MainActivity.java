package com.example.qenawi.chi_woo;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.qenawi.chi_woo.fragments.BlankFragment;
import com.example.qenawi.chi_woo.fragments.First_open;
import com.example.qenawi.chi_woo.fragments.add_fragment;
import com.example.qenawi.chi_woo.fragments.suit_me_fragment;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener,First_open.OnFragmentInteractionListener, add_fragment.OnFragmentInteractionListener,suit_me_fragment.OnFragmentInteractionListener {

public Stack<String>ORG;

    void Call_main_frag()
    {
        //-------------------------------------------------------
        ORG.push(getString(R.string.First_open));
        First_open fragment = new First_open();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.Place_holder, fragment,getString(R.string.First_open)); //Container -> R.id.contentFragment
        transaction.commit();
    }
    void Call_main_frag1()
    {
        //-------------------------------------------------------
        ORG.push(getString(R.string.add_frag));
        add_fragment fragment = new add_fragment();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.Place_holder, fragment,getString(R.string.add_frag)); //Container -> R.id.contentFragment
        transaction.commit();
    }
    void Call_main_frag0()
    {
        //-------------------------------------------------------

        BlankFragment fragment = new BlankFragment();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.Place_holder, fragment,"Tmp"); //Container -> R.id.contentFragment
        transaction.commit();
    }
    void Call_main_frag2()
    {
        //-------------------------------------------------------
        ORG.push(getString(R.string.Suit_me));
        suit_me_fragment fragment = new suit_me_fragment();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.Place_holder, fragment,getString(R.string.Suit_me)); //Container -> R.id.contentFragment
        transaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ORG=new Stack<>();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Call_main_frag();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) // Add Fragment all_FraGments
    {

    }

    @Override
    public void Call_Frag(int id)
    {
        if(0==id){ Call_main_frag1(); }//call add
        else {Call_main_frag2();}
    }

    @Override
    public void suit_me_listner(Uri uri)
    {

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            String MAin,add,Suit;
            MAin= getString(R.string.First_open); add=getString(R.string.add_frag);  Suit=getString(R.string.Suit_me);
            if (!ORG.pop().equals(MAin))
            {
                String CUrnt;

                CUrnt=ORG.peek();
                Log.v("hex","B  CUrnt"+CUrnt);
                // remove firts frag  and hide it
                // make visaple to the next fraGz

                CUrnt=ORG.peek();
                Log.v("hex","CUrnt"+CUrnt);
                Log.v("hex","sz->"+ORG.size());
                if(CUrnt==MAin){  Call_main_frag();}
                else if(CUrnt==add){Call_main_frag1();}
                else if(CUrnt==Suit){Call_main_frag2();}
            }
            else
                return super.onKeyDown(keyCode, event);
            // BAck as NorMal

        }
        return true;
    }

}
