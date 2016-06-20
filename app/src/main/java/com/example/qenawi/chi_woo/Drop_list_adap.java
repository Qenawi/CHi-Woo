package com.example.qenawi.chi_woo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by QEnawi on 6/17/2016.
 */
public class Drop_list_adap  extends ArrayAdapter {

    private Context context;
    LinearLayout ll;
    String sq[];
    private  int layoutResourceId;
    List<String> data;
    public Drop_list_adap(Context c,int layoutresourceid ,int txt_id,List<String> data)
    {
        super(c,layoutresourceid,txt_id,data);
        this.context=c;
        this.layoutResourceId =layoutresourceid;
        this.data = data;
        Resources res= getContext().getResources();
        sq=res.getStringArray(R.array.colrs2);
        Log.v("hex","called");
    }
    public  String solv(int pos )
    {
            return  sq[pos];
    }
    @Override
    public int getCount()
    {
        return data.size();
    }
    @Override
    public String getItem(int pos)
    {
        return  data.get(pos);
    }
    @Override
    public long getItemId(int pos)
    {
        return pos;
    }
    @Override
    public View getDropDownView(int pos, View convertView, ViewGroup parent)
    {
        super.getDropDownView(pos, convertView, parent);
        View_Holder holder2;
        if(null==convertView)
        {
            holder2=new View_Holder();
            LayoutInflater inflater=((Activity) context).getLayoutInflater();
            convertView=inflater.inflate(layoutResourceId,parent,false);
            holder2=new View_Holder();
            holder2.name=(TextView)convertView.findViewById(R.id.text23);
            holder2.daTa=(TextView)convertView.findViewById(R.id.Color_text23);
            convertView.setTag(holder2);
        }
        else
        {
            holder2=(View_Holder) convertView.getTag();
        }
        holder2.name.setText(data.get(pos).toString());
        String tmp=data.get(pos);
        holder2.daTa.setBackgroundColor(Color.parseColor(solv(pos)));
    //    save_my(tmp, holder2);
        return convertView;
    }

    @Override
    public View getView(int pos,View convertView,ViewGroup parent)
    {
        View_Holder holder;
    if(null==convertView)
    {
        LayoutInflater inflater=((Activity) context).getLayoutInflater();
        convertView=inflater.inflate(layoutResourceId,parent,false);
        holder=new View_Holder();
        holder.name=(TextView)convertView.findViewById(R.id.text23);
        holder.daTa=(TextView)convertView.findViewById(R.id.Color_text23);
        convertView.setTag(holder);
    }
    else
    {
        holder=(View_Holder) convertView.getTag();
    }
        holder.name.setText(data.get(pos).toString());
     String tmp=data.get(pos);
        holder.daTa.setBackgroundColor(Color.parseColor(solv(pos)));
    return convertView;
}
private static class View_Holder
{
    TextView name;
    TextView daTa;
}

}
