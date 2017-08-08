package cn.hello.demo2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.hello.demo2.adapter.ViewPagerAdapter;
import cn.hello.demo2.animation.RotateDownPageTransformer;
import cn.hello.demo2.fragment.SlideFirstFragment;
import cn.hello.demo2.fragment.SlideSecondFragment;
import cn.hello.demo2.fragment.SlideThreeFragment;



public class ViewPagerActivity extends FragmentActivity {

    private ViewPager viewPager;
    private SlideFirstFragment slideFirstFragment;
    private SlideSecondFragment slideSecondFragment;
    private SlideThreeFragment slideThreeFragment;

    private List<Fragment> fragmentList = new ArrayList<>();
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_pager);
        SharedPreferences preferences = getSharedPreferences("in", Context.MODE_PRIVATE);
        int flags = preferences.getInt("flags", 0);
        if (flags == 1) {
            Intent intent = new Intent(ViewPagerActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            initView();
        }


        //int flags = preferences.getInt("flags", 0);
    }

    private void initView(){

        viewPager = (ViewPager) findViewById(R.id.vp_activity);

        slideFirstFragment = new SlideFirstFragment();
        slideSecondFragment = new SlideSecondFragment();
        slideThreeFragment = new SlideThreeFragment();

        fragmentList.add(slideFirstFragment);
        fragmentList.add(slideSecondFragment);
        fragmentList.add(slideThreeFragment);

        SharedPreferences preferences = getSharedPreferences("in", Context.MODE_PRIVATE);
        preferences.edit().putInt("flags", 1).commit();

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);

        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true,new RotateDownPageTransformer());

    }
}
