package cn.hello.demo2.demo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.hello.demo2.R;
import cn.hello.demo2.db.ProvinceHelper;

/**
 * Created by Administrator on 2017/9/20.
 */

public class GetDbdataDemo extends AppCompatActivity{

    private static final String TAG = "GetDbdataDemo";

    private ProvinceHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydemo_main);
        dbHelper = new ProvinceHelper(this,"Area.db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("province",null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Log.d(TAG,"id is "+cursor.getString(cursor.getColumnIndex("id")));
                Log.d(TAG,"name is "+cursor.getString(cursor.getColumnIndex("name")));

            }while (cursor.moveToNext());
        }
        cursor.close();

    }
}
