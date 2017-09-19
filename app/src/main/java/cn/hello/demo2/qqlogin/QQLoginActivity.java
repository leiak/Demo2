package cn.hello.demo2.qqlogin;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.hello.demo2.R;

public class QQLoginActivity extends AppCompatActivity implements View.OnClickListener{

    private QQLoginVideoView videoview;
    private Button          btn_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqlogin);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        btn_enter = (Button) findViewById(R.id.btn_enter);
        btn_enter.setOnClickListener(this);

        videoview = (QQLoginVideoView) findViewById(R.id.videoview);
        videoview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sport));

        //播放
        videoview.start();
        //循环播放
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_enter:
                Toast.makeText(this,"登录成功了",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
