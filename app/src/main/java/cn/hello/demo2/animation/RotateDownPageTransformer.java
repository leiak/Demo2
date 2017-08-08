package cn.hello.demo2.animation;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/8/7.
 */

public class RotateDownPageTransformer implements ViewPager.PageTransformer {

    private static final float ROT_MAX = 20.0f;
    private float mRot;

    @Override
    public void transformPage(View view, float position) {

        //Log.d("RotateDown", view + " , " + position + "");

        Log.d("DepthPageTransformer", view.getTag() + " , " + position + "");

        if (position < -1)
        {
            //ViewHelper.setRotation(view, 0);

            view.setRotation(0);

        } else if (position <= 1)
        { // [-1,1]  这个页面还在屏幕右边缘即将滑入我们的视线
            if (position < 0)
            {

                mRot = (ROT_MAX * position);
                //ViewHelper.setPivotX(view, view.getMeasuredWidth() * 0.5f);
                //ViewHelper.setPivotY(view, view.getMeasuredHeight());
                //ViewHelper.setRotation(view, mRot);
                view.setPivotX(view.getMeasuredWidth() * 0.5f);
                view.setPivotY(view.getMeasuredHeight());
                view.setRotation(mRot);
            } else
            {

                mRot = (ROT_MAX * position);
                //ViewHelper.setPivotX(view, view.getMeasuredWidth() * 0.5f);
                //ViewHelper.setPivotY(view, view.getMeasuredHeight());
                //ViewHelper.setRotation(view, mRot);
                view.setPivotX(view.getMeasuredWidth() * 0.5f);
                view.setPivotY(view.getMeasuredHeight());
                view.setRotation(mRot);
            }



        } else
        {
            //ViewHelper.setRotation(view, 0);
            view.setRotation(0);
        }

    }
}
