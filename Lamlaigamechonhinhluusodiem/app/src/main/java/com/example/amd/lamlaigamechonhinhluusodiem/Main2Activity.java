package com.example.amd.lamlaigamechonhinhluusodiem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Main2Activity extends AppCompatActivity {
    TableLayout tbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tbl=(TableLayout)findViewById(R.id.table);
        int sodong=3;
        int socot=2;
        for(int i=1;i<=sodong;i++){
            TableRow tableRow = new TableRow(this);
            for(int j=1;j<=socot;j++){
                ImageView imageView= new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(180,180);
                imageView.setLayoutParams(layoutParams);
                final int vitri=socot*(i-1)+j-1;
                int idhinh=getResources().getIdentifier(MainActivity.arrayname.get(vitri),"drawable",getPackageName());
                imageView.setImageResource(idhinh);
                tableRow.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("tenhinhne",MainActivity.arrayname.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
            }
            tbl.addView(tableRow);
        }
    }
}
