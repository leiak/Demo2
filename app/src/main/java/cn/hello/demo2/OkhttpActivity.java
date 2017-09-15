package cn.hello.demo2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkhttpActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "Okhttp";

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
                    String url = "http://apicloud.mob.com/v1/weather/query?key=146d30f8f3b93&city=%E8%B5%A4%E5%B3%B0";

                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();


                    JSONObject weatherJSONObject = new JSONObject(responseData);
                    String msg = (String) weatherJSONObject.get("msg");
                    Log.d(TAG,"msg is "+msg);
                    JSONArray resultJSONArray = weatherJSONObject.getJSONArray("result");

                    JSONObject resultJSONObject = resultJSONArray.getJSONObject(0);
                    String result = resultJSONObject.getString("airCondition");
                    Log.d(TAG,"airCondition is "+result);

                    JSONArray futureJSONArray = resultJSONObject.getJSONArray("future");
                    for (int i=0;i<futureJSONArray.length();i++) {
                        String date = futureJSONArray.getJSONObject(i).getString("date");
                        Log.d(TAG,"date is "+date);
                    }


                }catch (Exception e){
                     e.printStackTrace();
                }

            }
        }).start();
    }

}
