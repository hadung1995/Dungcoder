package com.example.amd.savelogin;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText etname,etpass;
    CheckBox cb;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        etname=(EditText)findViewById(R.id.editText);
        etpass=(EditText)findViewById(R.id.editText2);
        cb=(CheckBox)findViewById(R.id.checkBox);
        sharedPreferences = getSharedPreferences("datalogin",MODE_PRIVATE);
        etname.setText(sharedPreferences.getString("username",""));
        etpass.setText(sharedPreferences.getString("password",""));
        cb.setChecked(sharedPreferences.getBoolean("checked",false));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id= etname.getText().toString();
                String pass=etpass.getText().toString();
                if(id.equals("admin")&&pass.equals("admin")){
                    if(cb.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",id);
                        editor.putString("password",pass);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.commit();
                    }
                }
            }
        });

    }
}
