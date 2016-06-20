package com.example.qenawi.chi_woo;

import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qenawi.chi_woo.DATA_BASE.Contract;
import com.example.qenawi.chi_woo.DATA_BASE.DATA_BASE_1;

import java.util.ArrayList;

/**
 * Created by QEnawi on 6/8/2016.
 */
public class read_Dp extends AsyncTask<Object,Void,ArrayList<String>>
{
    private ASync_TASK_LisTner1<ArrayList<String>> Call_BACK;
    public read_Dp( ASync_TASK_LisTner1<ArrayList<String>> cb)
    {
        this.Call_BACK = cb;
    }
    int tag;
    DATA_BASE_1 dp;
    ArrayList<String>GET_DATA1()
    {
        ArrayList<String>ret=new ArrayList<>();
        Cursor i=dp.get_shirts();
  while (i.moveToNext())
  {
      String tmp="";
      tmp+=i.getString(2);//Color
      tmp+=',';
      tmp+=i.getString(3);//DEscription
      ret.add(tmp);

  }
        return  ret;
    }
    ArrayList<String>GET_DATA2()
    {
        ArrayList<String>ret=new ArrayList<>();
        Cursor i=dp.get_pants();
        while (i.moveToNext())
        {
            String tmp="";
            tmp+=i.getString(2);//Color
            tmp+=',';
            tmp+=i.getString(3);//DEscription
            ret.add(tmp);
        }
        return  ret;
    }
    ArrayList<String>GET_DATA3()
    {
        ArrayList<String>ret=new ArrayList<>();
        Cursor i=dp.get_dezm();

        while (i.moveToNext())
        {
            String tmp="";
            tmp+=i.getString(2);//Color
            tmp+=',';
            tmp+=i.getString(3);//DEscription
            ret.add(tmp);

        }
        return  ret;
    }
    @Override
    protected ArrayList<String> doInBackground(Object[] params)
    {
        tag=(int)params[1];
        Log.v("hex","DATA Arrived  "+params[0].toString());
        dp=(DATA_BASE_1)params[2];
        //
        if(params[0].equals(Contract.Item_type1)){return  GET_DATA1();}
        else if(params[0].equals(Contract.Item_type2)){return  GET_DATA2();}
            else{return  GET_DATA3();}
    }
    @Override
    protected void onPostExecute(ArrayList<String> s)
    {
        super.onPostExecute(s);
        dp.close();
        Call_BACK.onTaskComplete(s, tag);
    }
}
