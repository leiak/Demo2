package cn.hello.demo2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkhttpActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "Okhttp";
    private Button btn;
    private TextView textok;


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //完成主界面更新,拿到数据
                    String data = (String)msg.obj;
                    textok.setText(data);
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        textok = (TextView) findViewById(R.id.textok);






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

                    Message msg2 =new Message();
                    msg2.obj = result; //可以是基本类型，可以是对象，可以是List、map等；
                    //mHandler.sendEmptyMessage(0);//这个相当于设置了msg2.what=0
                    msg2.what=0;
                    mHandler.sendMessage(msg2);



                }catch (Exception e){
                     e.printStackTrace();
                }

            }
        }).start();
    }

}
