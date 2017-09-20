package cn.hello.demo2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/9/20.
 */

public class ProvinceHelper extends SQLiteOpenHelper{


    private static final String DATABASE_NAME = "provinceDb.db";
    public ProvinceHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int
            version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table province( id integer,name String)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
