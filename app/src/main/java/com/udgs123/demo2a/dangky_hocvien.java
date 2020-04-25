package com.udgs123.demo2a;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dangky_hocvien extends AppCompatActivity {
//    private Button buttondongy1;
//    private Button buttonhuy1;
      Connection connect;

//    private TextView mDisplayDate;
//
//    private DatePickerDialog.OnDateSetListener mDateSetListener;
//    TextView selection;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_dangky_hocvien);

        final Button buttondongy1 = findViewById(R.id.buttondongy);
        buttondongy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText tentaikhoan = findViewById(R.id.edt_tentaikhoan);
                final EditText matkhau = findViewById(R.id.edt_matkhau);
                final EditText hoten = findViewById(R.id.edt_hotenhv);
                final EditText email = findViewById(R.id.edt_emailhv);
                final EditText sdt = findViewById(R.id.edt_sdthv);
                final EditText diachi = findViewById(R.id.edt_diachihv);
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (tentaikhoan.getText().toString().trim().equals("")
                        ||matkhau.getText().toString().trim().equals("")
                        ||hoten.getText().toString().trim().equals("")) {
                    Toast.makeText(dangky_hocvien.this, "Hãy nhập đầy đủ thông tin! ", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        ConnectHelper connectionHelper= new ConnectHelper();
                        connect=connectionHelper.connections();
                        if (connect==null) {
                            Toast.makeText(dangky_hocvien.this,"Kiểm tra kết nối của bạn! ",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            try {
                                PreparedStatement pst = connect.prepareStatement("insert into tthv values(?,?,?,?,?,?)");
                                pst.setString(1, tentaikhoan.getText().toString().trim());
                                pst.setString(2, matkhau.getText().toString().trim());
                                pst.setString(3, hoten.getText().toString().trim());
                                pst.setString(4, email.getText().toString().trim());
                                pst.setString(5, sdt.getText().toString().trim());
                                pst.setString(6, diachi.getText().toString().trim());
                                pst.executeUpdate();
                                Toast.makeText(getApplicationContext(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(dangky_hocvien.this, dangnhap.class));
                                connect.close();
                            } catch (SQLException e) {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }catch (Exception ex)
                    {
                        Toast.makeText(dangky_hocvien.this ,ex.getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
//        buttonhuy1 = (Button) findViewById(R.id.buttonhuy);
//        buttonhuy1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(dangky_hocvien.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
//    public class dangKy extends Async Task<String, String, Boolean> {
//        private ProgressDialog progressDialog;
//        private User user;
//        public dangKy(User user) {
//            this.user = user;
//            this.execute();
//        }
//
//    }
}
