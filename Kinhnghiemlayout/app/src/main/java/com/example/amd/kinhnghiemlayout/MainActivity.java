package com.example.amd.kinhnghiemlayout;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ListView;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Student> students;
    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter =new StudentAdapter(this,R.layout.student_list,students);
        lv.setAdapter(adapter);
    }
    public void AnhXa(){
        lv=(ListView)findViewById(R.id.listviewsinhvien);
       students = new ArrayList<>();
        students.add(new Student("Ha Thanh Dung","dung"));
        // sao báo lỗi hết ntn code của tôi hả ông?c l
        //ông ơi giờ ông làm project trên máy tôi được không ông?
        //nếu làm y chang ông mà nó cũng báo lỗi thì tôi xóa android studio cài lại
        // ko phải tại android đâu
        // ao lại thế nhỉ =))) ong lam lai bai cua ong tren may toi thu di ong
        // đợi tôi tí

        //

    }
}
