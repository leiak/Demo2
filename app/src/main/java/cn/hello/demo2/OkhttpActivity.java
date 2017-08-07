package cn.hello.demo2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkhttpActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                sendRequestWithOkHttp();
                break;

        }
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    String url = "http://m.baidu.com";

                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    //showResponse(responseData);
                    Log.d("showResponsedata",responseData);

                }catch (Exception e){
                     e.printStackTrace();
                }

            }
        }).start();
    }

}
