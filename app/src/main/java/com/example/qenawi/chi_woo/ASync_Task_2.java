package com.example.qenawi.chi_woo;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by QEnawi on 6/9/2016.
 */
public class ASync_Task_2 extends AsyncTask<Object,Void,ArrayList<String>>
{
    private ASync_TASK_LisTner1<ArrayList<String>> Call_BACK;
    int tag;
    ArrayList<String> shose,pants,shirts;
    public ASync_Task_2( ASync_TASK_LisTner1<ArrayList<String>> cb)
    {
        this.Call_BACK = cb;
    }
    public  ArrayList<String>creat_comp()
    {
ArrayList<String>res=new ArrayList<>();
for(int i=0;i<shirts.size();i++)
{
    for (int j=0;j<pants.size();j++)
        for (int k=0;k<shose.size();k++)
        {
            String tmp= shirts.get(i) +"\n"+ pants.get(j) +"\n "+ shose.get(k)+"\n";
            res.add(tmp);
            Log.v("hex",tmp+"  ..................... ");
        }
}
        return  res;
    }
    @Override
    protected ArrayList<String> doInBackground(Object[] params)
    {

        tag=(int)params[0];
       shirts= (ArrayList<String>) params[1];//shirts
        pants=(ArrayList<String>)  params[2];//pants
        shose=(ArrayList<String>)   params[3];//shose

       return creat_comp();
    }
    @Override
    protected  void  onPostExecute(ArrayList<String>ret)
    {
        super.onPostExecute(ret);
        Call_BACK.onTaskComplete(ret,tag);
    }
}
