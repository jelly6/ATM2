package com.scc.jellyfish6.atm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jelly on 18/2/20.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    //singleton mode avoid重複開資料庫
    private static MyDBHelper instance=null;
    public static MyDBHelper getInstance(Context ctx){
        if(instance==null){
            instance=new MyDBHelper(ctx,"expanse.db",null,1);
        }
        return instance;
    }
    //public改成private
    private MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//很重要db bug
        db.execSQL("CREATE TABLE main.exp "+
                "(_id INTEGER PRIMARY KEY  NOT NULL,"+
                "cdate DATETIME NOT NULL," +
                "details VARCHAR," +
                "amount INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
