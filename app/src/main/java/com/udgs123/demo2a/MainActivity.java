package com.udgs123.demo2a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttondangnhap1;
    private Button buttondangky1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttondangnhap1 = (Button) findViewById(R.id.buttondangnhap);
        buttondangnhap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,dangnhap.class);
                startActivity(intent);
            }
        });
        buttondangky1 = (Button) findViewById(R.id.buttondangky);
        buttondangky1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this,dangky_hocvien.class);
                startActivity(intent);
            }
        });
    }
}
