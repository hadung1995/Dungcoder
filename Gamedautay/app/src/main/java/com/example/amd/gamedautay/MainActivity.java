package com.example.amd.gamedautay;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtdiem;
    ImageButton ibt_play;
    SeekBar sb7,sb8,sb9;
CheckBox cb7,cb8,cb9;
    int diem=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        final CountDownTimer countdowntimer = new CountDownTimer(60000,200) {
            @Override
            public void onTick(long l) {
                Random r =new Random();
                int so1=r.nextInt(5-1)+1;
                int so2=r.nextInt(5-1)+1;
                int so3=r.nextInt(5-1)+1;
                sb7.setProgress(sb7.getProgress()+so1);
                sb8.setProgress(sb8.getProgress()+so2);
                sb9.setProgress(sb9.getProgress()+so3);
                if(sb7.getProgress()==sb7.getMax()){
                    this.cancel();
                    ibt_play.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Con thu nhat",Toast.LENGTH_SHORT).show();
                    if(cb7.isChecked()){
                       diem+=5;
                    }
                    else{
                        diem-=2;
                    }
                }
                if(sb8.getProgress()==sb8.getMax()){
                    this.cancel();
                    ibt_play.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Con thu 2",Toast.LENGTH_SHORT).show();
                    if(cb8.isChecked()){
                        diem+=5;
                    }
                    else{
                        diem-=2;
                    }
                }
                if(sb9.getProgress()==sb9.getMax()){
                    this.cancel();
                    ibt_play.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Con thu nhat",Toast.LENGTH_SHORT).show();
                    if(cb9.isChecked()){
                        diem+=5;
                    }
                    else{
                        diem-=2;
                    }
                }
            }

            @Override
            public void onFinish() {

            }
        };
        ibt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb7.isChecked()||cb8.isChecked()||cb9.isChecked()){
                    sb7.setProgress(9);
                    sb8.setProgress(9);
                    sb9.setProgress(0);
                    ibt_play.setVisibility(View.INVISIBLE);
                   countdowntimer.start();
                }
                else{
                    Toast.makeText(MainActivity.this,"Vui lòng chọn 1 trong 3 ô trên",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void AnhXa(){
        txtdiem=(TextView)findViewById(R.id.textView2);
        cb7=(CheckBox)findViewById(R.id.checkBox7);
        cb8=(CheckBox)findViewById(R.id.checkBox8);
        cb9=(CheckBox)findViewById(R.id.checkBox9);
        sb7=(SeekBar)findViewById(R.id.seekBar7);
        sb8=(SeekBar)findViewById(R.id.seekBar8);
        sb9=(SeekBar)findViewById(R.id.seekBar9);
        ibt_play=(ImageButton)findViewById(R.id.imageButton2);
    }
}
