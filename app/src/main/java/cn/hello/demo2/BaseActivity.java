package cn.hello.demo2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BaseActivity extends AppCompatActivity {

    private ActionBar actionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity",getClass().getSimpleName());
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("BaseActivity",getClass().getSimpleName());
        ActivityController.removeActivity(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    //no understand
    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,Main2Activity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }
}
