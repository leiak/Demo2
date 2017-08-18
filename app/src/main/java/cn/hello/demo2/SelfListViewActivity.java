package cn.hello.demo2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.hello.demo2.adapter.FruitAdapter;

public class SelfListViewActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_list_view);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(SelfListViewActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.selflistview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                  Fruit fruit = fruitList.get(position);
                  Toast.makeText(SelfListViewActivity.this,fruit.getFruitName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits(){
        for(int i=0;i<=2;i++){
             Fruit apple = new Fruit("Apple",R.drawable.img1);
             fruitList.add(apple);
            Fruit apple2 = new Fruit("Apple2",R.drawable.img2);
            fruitList.add(apple2);
            Fruit apple3 = new Fruit("Apple3",R.drawable.img3);
            fruitList.add(apple3);
            Fruit apple4 = new Fruit("Apple4",R.drawable.img1);
            fruitList.add(apple4);
            Fruit apple5 = new Fruit("Apple5",R.drawable.img2);
            fruitList.add(apple5);
            Fruit apple6 = new Fruit("Apple6",R.drawable.img3);
            fruitList.add(apple6);
            Fruit apple7 = new Fruit("Apple7",R.drawable.img1);
            fruitList.add(apple7);
        }
    }
}
