package com.example.amd.student_manager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by AMD on 12/2/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    Context context;
    int class_id;
    int course_id;

    public FragmentAdapter(FragmentManager fm, Context context, int class_id, int course_id) {
        super(fm);
        this.context = context;
        this.class_id = class_id;
        this.course_id = course_id;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                StudentFragment f1 = new StudentFragment();
                Bundle b1 = new Bundle();
                b1.putString("chu", "tui la fragment 1 ne");
                b1.putInt("so1",class_id);
                b1.putInt("so2",course_id);
                f1.setArguments(b1);
                return f1;
            case 1:
                SubjectFragment f2 = new SubjectFragment();
                Bundle b2 = new Bundle();
                b2.putInt("hinh", R.drawable.add);
                b2.putInt("so",class_id);
                f2.setArguments(b2);
                return f2;
        }

        StudentFragment f = new StudentFragment();
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
        return ((Student_SubjectActivity)context).title[position];

    }
}
