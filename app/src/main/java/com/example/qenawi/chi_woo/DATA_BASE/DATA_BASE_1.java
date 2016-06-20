package com.example.qenawi.chi_woo.DATA_BASE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by QEnawi on 6/6/2016.
 */
public class DATA_BASE_1 extends SQLiteOpenHelper implements Serializable{


    public DATA_BASE_1(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);//Crate DP
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.v("hex","created");
        db.execSQL(" Create Table " + Contract.Table_name +
                        " (" + Contract.Table_id + " integer primary key autoincrement, " +
                        Contract.Item_type + " text not null, " +
                        Contract.Item_color + " text not null, " +
                        Contract.Item_Description + " text not null)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " +Contract.Table_name);

    }
     public Boolean insert( DP_item data)
     {
         Log.v("hex","created1");
     //    int ret=0;
         SQLiteDatabase dp=this.getWritableDatabase();
         Log.v("hex","created2");
         ContentValues cv=new ContentValues();
        cv.put(Contract.Item_type,data.getType());
         cv.put(Contract.Item_color,data.getColor());
         cv.put(Contract.Item_Description,data.getDescreption());
         try {
             dp.insert(Contract.Table_name,null,cv);

         }catch (Exception e){e.printStackTrace();}

          return true;
     }
public  void Drop()
{
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL("DROP TABLE IF EXISTS " +Contract.Table_name);
    db.execSQL(" Create Table " + Contract.Table_name +
                    " (" + Contract.Table_id + " integer primary key autoincrement, " +
                    Contract.Item_type + " text not null, " +
                    Contract.Item_color + " text not null, " +
                    Contract.Item_Description + " text not null)"
    );
}
    public Cursor get_shirts()
    {
        SQLiteDatabase dp = this.getWritableDatabase();
        String query = "Select * from " + Contract.Table_name + " where " + Contract.Item_type + " = ?";
        Cursor res = dp.rawQuery(query, new String[]{Contract.Item_type1});
        return res;
    }
    public Cursor get_pants()
    {
        SQLiteDatabase dp = this.getWritableDatabase();
        String query = "Select * from " + Contract.Table_name + " where " + Contract.Item_type + " = ?";
        Cursor res = dp.rawQuery(query, new String[]{Contract.Item_type2});
        return res;
    }
    public Cursor get_dezm()
    {
        SQLiteDatabase dp = this.getWritableDatabase();
        String query = "Select * from " + Contract.Table_name + " where " + Contract.Item_type + " = ?";
        Cursor res = dp.rawQuery(query, new String[]{Contract.Item_type3});
        return res;
    }


}
