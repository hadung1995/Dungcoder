package com.example.amd.fragment_1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    ViewPager viewpager;
    TabLayout tablayout;
    String[] title = {"Login", "Sign up"};
    MyAdapter adapter;
    int id=4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.sliding_tabs);


         adapter = new MyAdapter(getSupportFragmentManager(),MainActivity.this);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        viewpager.setCurrentItem(1);


    }



//    public class MyAdapter extends FragmentPagerAdapter {
//
//        public MyAdapter(FragmentManager fm) {
//            super(fm);
//
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//
//            switch (position) {
//                case 0:
//                    ChuFragment f1 = new ChuFragment();
//                    Bundle b1 = new Bundle();
//                    b1.putString("chu", "tui la fragment 1 ne");
//                    b1.putInt("so",id);
//                    f1.setArguments(b1);
//                    return f1;
//                case 1:
//                    HinhFragment f2 = new HinhFragment();
//                    Bundle b2 = new Bundle();
//                    b2.putInt("hinh", R.drawable.add);
//                    f2.setArguments(b2);
//                    return f2;
//            }
//
//            ChuFragment f = new ChuFragment();
//            return f;
//        }
//
//
//        @Override
//        public int getCount() {
//            return 2;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
////            Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
////            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
////            SpannableString sb = new SpannableString(" ");
////            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
////            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            return title[position];
//
//        }
//    }
    //        et.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                TextInputLayout t=(TextInputLayout)findViewById(R.id.username_text_input_layout);
//                String username=et.getText().toString();
//                if(username.equals("hathanhdung")){
//                t.setError("Chao ban nhe");
//                }
//
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(findViewById(R.id.root),"chac chua",5000).setActionTextColor(Color.RED).setAction("OK", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                }).show();
//            }
//        });
}
