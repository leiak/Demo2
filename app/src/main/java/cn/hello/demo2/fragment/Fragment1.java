package cn.hello.demo2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.hello.demo2.Fruit;
import cn.hello.demo2.R;
import cn.hello.demo2.adapter.FirstFragmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    private List<Fruit> fruitList = new ArrayList<>();

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        //(Button) button5 = view.findViewById(R.id.button5)
        ListView listView = (ListView)view.findViewById(R.id.listviewfragment1);
        initFruits();
        listView.setAdapter(new FirstFragmentAdapter(getActivity(), fruitList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(getActivity(),fruit.getFruitName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
