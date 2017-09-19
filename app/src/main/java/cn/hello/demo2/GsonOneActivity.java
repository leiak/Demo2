package cn.hello.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import cn.hello.demo2.bean.User;

public class GsonOneActivity extends AppCompatActivity {

    private static final String TAG = "GsonOne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_one);



        User user = new User(1,"zhangsan","zs123");

        Log.d(TAG,user.toString());

        Gson gson = new Gson();

        String userJson = gson.toJson(user);

        Log.d(TAG,userJson);

        User userfrom = gson.fromJson(userJson,User.class);

        String userfromname = userfrom.getUsername();

        Log.d(TAG,"userfromname = "+userfromname);

        String jsonString = "{\"id\":2,\"username\":\"怪盗kidou\",\"password\":\"kidou\"}";
        User user2 = gson.fromJson(jsonString, User.class);

        String username2 = user2.getUsername();

        Log.d(TAG,"username2 = "+username2);







    }
}
