package cn.hello.demo2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.hello.demo2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFirstFragment extends Fragment {


    public SlideFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide_first, container, false);
    }



}
