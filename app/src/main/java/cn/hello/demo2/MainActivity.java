package cn.hello.demo2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private ProgressBar progressBar;
    private ProgressDialog dialog4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);




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
            default:
                break;

        }
    }
}
