package com.example.amd.cuocduakythu;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    CheckBox tb1,tb2,tb3;
    SeekBar sb4,sb5,sb6;
    ImageButton ibt_play;
    int diem=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                Random r =new Random();
                int number=r.nextInt(5-1)+1;
                int number1=r.nextInt(5-1)+1;
                int number2=r.nextInt(5-1)+1;
                sb4.setProgress(sb4.getProgress()+number);
                sb5.setProgress(sb5.getProgress()+number1);
                sb6.setProgress(sb6.getProgress()+number2);
                if(sb4.getProgress()==sb4.getMax()){
                    this.cancel();
                    ibt_play.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Số 1 thắng",Toast.LENGTH_SHORT).show();
                    if(tb1.isChecked()){
                        diem+=5;
                    }
                    else{
                        diem-=2;
                    }
                    tv.setText("so diem"+diem);
                    enable();
                }
                if(sb5.getProgress()==sb5.getMax()){
                    this.cancel();
                    ibt_play.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Số 2 thắng",Toast.LENGTH_SHORT).show();
                    if(tb2.isChecked()){
                        diem+=5;
                    }
                    else{
                        diem-=2;
                    }
                    tv.setText("so diem"+diem);
                    enable();
                }
                if(sb6.getProgress()==sb6.getMax()){
                    this.cancel();
                    ibt_play.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Số 3 thắng",Toast.LENGTH_SHORT).show();
                    if(tb3.isChecked()){
                        diem+=5;
                    }
                    else{
                        diem-=2;
                    }
                    tv.setText("so diem"+diem);
                    enable();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        ibt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb1.isChecked()||tb2.isChecked()||tb3.isChecked()){
                    sb4.setProgress(0);
                    sb5.setProgress(0);
                    sb6.setProgress(0);
                    ibt_play.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    disable();
                }
               else{
                    Toast.makeText(MainActivity.this,"Vui lòng chọn 1 trong 3 ô trên",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tb2.setChecked(false);
                    tb3.setChecked(false);
                }
            }
        });
        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tb3.setChecked(false);
                    tb1.setChecked(false);
                }
            }
        });
        tb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tb2.setChecked(false);
                    tb1.setChecked(false);
                }
            }
        });
    }
    private void AnhXa(){
        tv=(TextView)findViewById(R.id.textView2);
        tb1=(CheckBox)findViewById(R.id.checkBox7);
        tb2=(CheckBox)findViewById(R.id.checkBox8);
        tb3=(CheckBox)findViewById(R.id.checkBox9);
        sb4=(SeekBar)findViewById(R.id.seekBar7);
        sb5=(SeekBar)findViewById(R.id.seekBar8);
        sb6=(SeekBar)findViewById(R.id.seekBar9);
        ibt_play=(ImageButton)findViewById(R.id.imageButton2);
    }
    private void enable(){
        tb1.setEnabled(true);
        tb2.setEnabled(true);
        tb3.setEnabled(true);
    }
    private void disable(){
        tb1.setEnabled(false);
        tb2.setEnabled(false);
        tb3.setEnabled(false);
    }
}
