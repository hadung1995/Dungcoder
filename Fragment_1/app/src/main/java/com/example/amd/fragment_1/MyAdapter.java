package com.example.amd.fragment_1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by AMD on 12/1/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    Context context;

    public MyAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    //    public MyAdapter(FragmentManager fm,int id,Context context) {
//        super(fm);
//
//    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ChuFragment f1 = new ChuFragment();
                Bundle b1 = new Bundle();
                b1.putString("chu", "tui la fragment 1 ne");
                b1.putInt("so",((MainActivity)context).id);
                f1.setArguments(b1);
                return f1;
            case 1:
                HinhFragment f2 = new HinhFragment();
                Bundle b2 = new Bundle();
                b2.putInt("hinh", R.drawable.add);
                f2.setArguments(b2);
                return f2;
        }

        ChuFragment f = new ChuFragment();
        return f;
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//            Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
//            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//            SpannableString sb = new SpannableString(" ");
//            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ((MainActivity)context).title[position];

    }
}