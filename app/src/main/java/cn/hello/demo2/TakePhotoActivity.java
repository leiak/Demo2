package cn.hello.demo2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;


public class TakePhotoActivity extends BaseActivity implements View.OnClickListener{

    private Uri imageUrl;
    private ImageView imageView;

    private static final String TAG = "TakePhotoActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);

        Button button = (Button) findViewById(R.id.take_photo);
        imageView = (ImageView) findViewById(R.id.picture);

        button.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.take_photo:
                File outputImage = new File(Environment.getExternalStorageDirectory(),"out_image.jpg");
//                String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
//                if (state.equals(Environment.MEDIA_MOUNTED)){   //如果可用
//                    Toast.makeText(this,"sdcard可用",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(this,"sdcard不可用",Toast.LENGTH_SHORT).show();
//                }


                //File outputImage = new File("/storage/emulated/0/Android/data/cn.hello.demo2/cache/out_image.jpg");
//                try {
//                    if (outputImage.exists()) {
//                        outputImage.delete();
//                    }
//                    outputImage.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (Build.VERSION.SDK_INT >= 24) {
                    imageUrl = FileProvider.getUriForFile(this, "cn.hello.demo2.fileprovider", outputImage);
                    //intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUrl);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                } else {
                    //imageUrl = Uri.fromFile(outputImage);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUrl);
                }
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case 1:
                //显示照片到imageview
//                if (resultCode == REQUEST_OK) {
                    Bitmap bitmap = null;
                        if (Build.VERSION.SDK_INT >= 24) {
                            //Bitmap bmp = (Bitmap) data.getExtras().get("data");

                            try {
                                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUrl));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            imageView.setImageBitmap(bitmap);
                            Toast.makeText(this, "is ok1", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "is ok");
                        } else {
                            bitmap = (Bitmap) data.getExtras().get("data");
                            Toast.makeText(this, "is ok2", Toast.LENGTH_SHORT).show();
                            imageView.setImageBitmap(bitmap);
                        }

//                }

                break;
            default:
                Toast.makeText(this,"has error",Toast.LENGTH_SHORT).show();
                break;


        }

    }

}
