package cn.hello.demo2;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private ProgressBar progressBar;
    private ProgressDialog dialog4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //add something

        TextView testView = (TextView) findViewById(R.id.maintext);

        testView.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.btnpro);
        button4.setOnClickListener(this);

        progressBar = (ProgressBar) findViewById(R.id.proid);

        Button button5 = (Button) findViewById(R.id.btndia);
        button5.setOnClickListener(this);

        Button button6 = (Button) findViewById(R.id.btnprodia);
        button6.setOnClickListener(this);

        Button buttonlistview = (Button) findViewById(R.id.btnlistview);
        buttonlistview.setOnClickListener(this);
        Button btnselflistview = (Button) findViewById(R.id.btnselflistview);
        btnselflistview.setOnClickListener(this);

        /*broadcast-receiver demo*/
        Button btnbroadcast = (Button) findViewById(R.id.btnbroadcast);
        btnbroadcast.setOnClickListener(this);

        /*okhttp demo*/
        Button btnokhttp = (Button) findViewById(R.id.btnokhttp);
        btnokhttp.setOnClickListener(this);
        /*baidu map demo*/
        Button btnbaidumap = (Button) findViewById(R.id.btnbaidumap);
        btnbaidumap.setOnClickListener(this);

        Button btnbaidumap2 = (Button) findViewById(R.id.btnbaidumap2);
        btnbaidumap2.setOnClickListener(this);

        Button btnwelcome = (Button) findViewById(R.id.btnwelcome);
        btnwelcome.setOnClickListener(this);

        Button btnDrawerLayout = (Button) findViewById(R.id.btnDrawerLayout);
        btnDrawerLayout.setOnClickListener(this);

        Button PulltoRefresh = (Button) findViewById(R.id.PulltoRefresh);
        PulltoRefresh.setOnClickListener(this);

        Button Notification = (Button) findViewById(R.id.notification);
        Notification.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.maintext:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                Intent intent2 = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnpro:
                int progress = progressBar.getProgress();
                progress = progress+10;
                progressBar.setProgress(progress);
                break;
            case R.id.btnlistview:
                Intent intent3 = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent3);
                break;
            case R.id.btnselflistview:
                Intent intent4 = new Intent(MainActivity.this,SelfListViewActivity.class);
                startActivity(intent4);
                break;
            case R.id.btnbroadcast:
                Intent intentbroadcast = new Intent(MainActivity.this,BroadcastActivity.class);
                startActivity(intentbroadcast);
                break;
            case R.id.btnokhttp:
                Intent intentokhhtp = new Intent(MainActivity.this,OkhttpActivity.class);
                startActivity(intentokhhtp);
                break;
            case R.id.btnbaidumap:
                Intent intentbaidumap = new Intent(MainActivity.this,BaiduMapActivity.class);
                startActivity(intentbaidumap);
                break;
            case R.id.btnbaidumap2:
                Intent intentbaidumap2 = new Intent(MainActivity.this,BaiduMapSecondActivity.class);
                startActivity(intentbaidumap2);
                break;
            case R.id.btnwelcome:
                Intent intentwelcome = new Intent(MainActivity.this,WelcomeActivity.class);
                startActivity(intentwelcome);
                break;
            case R.id.btnDrawerLayout:
                Intent intentDrawerLayout = new Intent(MainActivity.this,DrawerLayoutActivity.class);
                startActivity(intentDrawerLayout);
                break;
            case R.id.btndia:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("hello title");
                dialog.setMessage("hello message");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
                dialog.show();
                break;
            case R.id.btnprodia:
                ProgressDialog dialog4 = ProgressDialog.show(this, "提示", "正在登陆中", false, true);
                break;
            case R.id.PulltoRefresh:
                Intent pulltorefresh = new Intent(MainActivity.this,PullToRefreshActivity.class);
                startActivity(pulltorefresh);
                break;
            case R.id.notification:
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;

        }
    }

    //两秒内按返回键两次退出程序
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
