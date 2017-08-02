package cn.hello.demo2;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, List<Fruit> objects) {
        super(context, resource,objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Fruit fruit = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        } else {
            Log.d("FruitAdapter","use convertView");
            view = convertView;
        }

        ImageView  imageView = (ImageView) view.findViewById(R.id.imgid);
        TextView textView = (TextView) view.findViewById(R.id.fruitname);
        imageView.setImageResource(fruit.getImgid());
        textView.setText(fruit.getFruitName());
        return view;
    }
}
