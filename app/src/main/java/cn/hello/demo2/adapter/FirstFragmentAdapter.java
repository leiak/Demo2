package cn.hello.demo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.hello.demo2.Fruit;
import cn.hello.demo2.R;


/**
 * Created by Administrator on 2017/8/10.
 */

public class FirstFragmentAdapter extends BaseAdapter {

    private List<Fruit> list;
    private Context context;
    public FirstFragmentAdapter(Context context, List<Fruit> list) {

        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if(view==null){
            vh=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.fruit_item,null);
            vh.image=(ImageView)view.findViewById(R.id.imgid);
            vh.title=(TextView)view.findViewById(R.id.fruitname);
            view.setTag(vh);
        }else{
            vh=(ViewHolder)view.getTag();
        }
        Fruit fruit=list.get(i);
        vh.image.setImageResource(fruit.getImgid());
        vh.title.setText(fruit.getFruitName());
        return view;
    }

    private class ViewHolder{
        ImageView image;
        TextView   title;
    }


}
