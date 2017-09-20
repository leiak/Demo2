package cn.hello.demo2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.hello.demo2.bean.Province;
import cn.hello.demo2.util.HttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ListViewActivity extends BaseActivity {

    private static final String TAG = "basiclistview";

    private String address = "http://guolin.tech/api/china";

    private List<Province> mProvincesData = new ArrayList<>();

    private List<String> showData = new ArrayList<>();

    private String[] data2 = {"app","app","app","app","app","app"};

    private  ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        queryProvinces();


    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //完成主界面更新,拿到数据
                    mProvincesData = (ArrayList)msg.obj;
                    for (Province province : mProvincesData) {
                        showData.add(province.getName());
                    }
                    adapter = new ArrayAdapter<>(
                            ListViewActivity.this,android.R.layout.simple_list_item_1,showData);
                    //adapter.notifyDataSetChanged();
                    ListView listView = (ListView) findViewById(R.id.listview1);
                    listView.setAdapter(adapter);
                    break;
                default:
                    break;
            }
        }

    };
    private void queryProvinces(){
        HttpUtil.sendOkHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(ListViewActivity.this,"加载失败",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                try {
                    JSONArray responseArray = new JSONArray(responseText);
                    for (int i=0;i < responseArray.length();i++) {
                        JSONObject responseObject = responseArray.getJSONObject(i);
                        Province mProvince = new Province();
                        mProvince.setId(responseObject.getInt("id"));
                        mProvince.setName(responseObject.getString("name"));
                        //Log.d(TAG,"mProvince id is "+ responseObject.getInt("id"));
                        //Log.d(TAG,"mProvince name is "+ responseObject.getString("name"));
                        mProvincesData.add(mProvince);


                    }
                    Message msg2 =new Message();
                    msg2.obj = mProvincesData; //可以是基本类型，可以是对象，可以是List、map等；
                    //mHandler.sendEmptyMessage(0);//这个相当于设置了msg2.what=0
                    msg2.what=0;
                    mHandler.sendMessage(msg2);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
