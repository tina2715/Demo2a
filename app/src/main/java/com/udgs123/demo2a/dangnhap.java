package com.udgs123.demo2a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class dangnhap extends AppCompatActivity {
    TextView textView;
    Connection connect;

    private Button buttondangnhap1;

    private Button buttonthoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        final Button login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(dangnhap.this, ManHinhDauTien.class);
//                startActivity(intent);
                final EditText tentaikhoan = (EditText) findViewById(R.id.edt_user);
                final EditText matkhau = (EditText) findViewById(R.id.edt_password);
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (tentaikhoan.getText().toString().trim().equals("")||matkhau.getText().toString().trim().equals("")) {
                    Toast.makeText(dangnhap.this, "Hãy nhập tên tài khoản và mật khẩu! ", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        ConnectHelper connectionHelper= new ConnectHelper();
                        connect=connectionHelper.connections();
                        if ( connect == null ) {
                            Toast.makeText(dangnhap.this, "Kiểm tra kết nối của bạn! ", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String tentaikhoan1= tentaikhoan.getText().toString().trim();
                            String matkhau1 = matkhau.getText().toString().trim();
                            progressBar.setVisibility(View.VISIBLE);
                            String query ="select * from taikhoan_hv where tentaikhoan_hv = '" + tentaikhoan1 + "' and matkhau_hv = '"+ matkhau1 +"' ";
                            Statement stmt = connect.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next())
                            {
                                startActivity(new Intent(dangnhap.this, ManHinhDauTien.class));
                                connect.close();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                            else
                            {
                                progressBar.setVisibility(View.VISIBLE);
                                Toast.makeText(dangnhap.this ,"Nhập thiếu trường", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    }catch (Exception ex)
                    {
                        Toast.makeText(dangnhap.this ,ex.getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        buttonthoat = (Button) findViewById(R.id.buttonthoat);
        buttonthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, MainActivity.class);
                startActivity(intent);
            }
        });
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                Intent intent = new Intent(dangnhap.this, doimatkhau.class);
                startActivity(intent);
            }
        });
    }
}
