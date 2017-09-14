package cn.hello.demo2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import cn.hello.demo2.util.WaveView;

public class WaveActivity extends AppCompatActivity {

    @BindView(R.id.waveview)
    WaveView mWaveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        //mWaveView = (WaveView) findViewById(R.id.waveview);
        mWaveView.setMax(100);
        mWaveView.setProgress(25);
        mWaveView.setMode(WaveView.MODE_CIRCLE);
        mWaveView.setSpeed(WaveView.SPEED_SLOW);
        mWaveView.setWaveColor(Color.RED);

    }
}
