package cn.hello.demo2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SharedPreferenceActivity extends AppCompatActivity {

    private static final String TAG = "SharedPreference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        Button sharedBtn = (Button) findViewById(R.id.sharebtn);

        sharedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = (SharedPreferences.Editor) getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name","leilei");
                editor.putBoolean("isboolean",true);
                editor.putInt("number",20);
                editor.apply();
                Log.d(TAG,"add data ok");
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(SharedPreferenceActivity.this);
                SharedPreferences.Editor editor1 = defaultSharedPreferences.edit();
                editor1.putString("name","leilei");
                editor1.putBoolean("isboolean",true);
                editor1.putInt("number",20);
                editor1.apply();
                Log.d(TAG,"add data1 ok");




            }
        });

        Button getData = (Button) findViewById(R.id.getdata);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharepf = getSharedPreferences("data",MODE_PRIVATE);
                String name = sharepf.getString("name","");
                Boolean isbo = sharepf.getBoolean("isboolean",false);
                int number = sharepf.getInt("number",0);
                Log.d(TAG,"name is "+name);
                Log.d(TAG,"isboolean is "+isbo);
                Log.d(TAG,"number is "+number);
            }
        });


    }
}
