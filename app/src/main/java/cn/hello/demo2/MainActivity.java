package cn.hello.demo2;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.hello.demo2.qqlogin.QQLoginActivity;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private ProgressBar progressBar;
    private ProgressDialog dialog4;
    private MZBannerView mMZBanner;

    public static final String[] IMGS = new String[]{"http://img3.imgtn.bdimg.com/it/u=1157091805,2188328024&fm=26&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1704332224,615354977&fm=200&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=1996140688,1469391704&fm=200&gp=0.jpg"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        int id = R.layout.activity_main;
        Log.d(TAG,"id is "+id);

        //add something
        //固定竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //状态栏全透明 并且高度也变为0  底部view顶到最上边
        //StatusBarUtil.transparencyBar(this);

        //TextView testView = (TextView) findViewById(R.id.maintext);

        //testView.setOnClickListener(this);

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

        Button Notification2 = (Button) findViewById(R.id.notification2);
        Notification2.setOnClickListener(this);

        Button takephoto = (Button) findViewById(R.id.takephoto);
        takephoto.setOnClickListener(this);

        Button waveview = (Button) findViewById(R.id.waveview);
        waveview.setOnClickListener(this);

        Button sharedPre = (Button) findViewById(R.id.sharePre);
        sharedPre.setOnClickListener(this);

        Button btngson = (Button) findViewById(R.id.btngson);
        btngson.setOnClickListener(this);

        Button qqlogin = (Button) findViewById(R.id.qqlogin);
        qqlogin.setOnClickListener(this);

        mMZBanner = (MZBannerView) findViewById(R.id.banner);

        final List<String> list = new ArrayList<>();
        for (int i = 0; i < IMGS.length; i++) {
            list.add(IMGS[i]);
        }

        // 设置数据
        mMZBanner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        mMZBanner.setDelayedTime(5000);






    }

    @Override
    protected void onResume() {
        super.onResume();
        mMZBanner.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMZBanner.pause();
    }

    public class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, final int position, String data) {

            Log.d(TAG,data);
            Log.d(TAG,"onBind id is "+position);

            Glide.with(MainActivity.this).load(data)
                    .bitmapTransform(new RoundedCornersTransformation(context, 15, 0, RoundedCornersTransformation.CornerType.ALL))
                    .into(mImageView);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "you click the "+position+" image", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qqlogin:
                Intent qqlogin = new Intent(this, QQLoginActivity.class);
                startActivity(qqlogin);
                break;
            case R.id.btngson:
                Intent btngson = new Intent(this,GsonOneActivity.class);
                startActivity(btngson);
                break;
            case R.id.sharePre:
                Intent sharePre = new Intent(this,SharedPreferenceActivity.class);
                startActivity(sharePre);
                break;
            case R.id.waveview:
                Intent waveview = new Intent(this,WaveActivity.class);
                startActivity(waveview);
                break;
            case R.id.takephoto:
                Intent takephoto = new Intent(MainActivity.this,TakePhotoActivity.class);
                startActivity(takephoto);
                break;
//            case R.id.maintext:
//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//                startActivity(intent);
//                break;
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
            case R.id.notification2:
                Intent notificationIntent = new Intent(MainActivity.this,NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
                NotificationManager manager2 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification2 = new NotificationCompat.Builder(this)
                        .setContentTitle("This is intent text")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();
                manager2.notify(1,notification2);
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
