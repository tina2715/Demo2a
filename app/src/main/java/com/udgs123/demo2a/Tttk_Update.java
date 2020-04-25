package com.udgs123.demo2a;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Tttk_Update extends AppCompatActivity {
    EditText edt_hotenhv, edt_emailhv, edt_sdthv, edt_diachihv;
    TextView tv_tentaikhoanhv;
    Connection connect;
    Button btn_luu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tttk__update);

        tv_tentaikhoanhv = (TextView) findViewById(R.id.tv_tentaikhoanhv);
        edt_hotenhv = (EditText) findViewById(R.id.edt_hotenhv);
        edt_emailhv = (EditText) findViewById(R.id.edt_emailhv);
        edt_sdthv = (EditText) findViewById(R.id.edt_sdthv);
        edt_diachihv = (EditText) findViewById(R.id.edt_diachihv);
        btn_luu = (Button) findViewById(R.id.btn_luu);


        btn_luu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  edt_hotenhv.setText(getIntent().getStringExtra("Hotenhv"));
                  edt_emailhv.setText(getIntent().getStringExtra("Emailhv"));
                  edt_sdthv.setText(getIntent().getStringExtra("Sdthv"));
                  edt_diachihv.setText(getIntent().getStringExtra("Diachihv"));
                try {
                    ConnectHelper connectHelper = new ConnectHelper();
                    connect = connectHelper.connections();
                    if (connect==null) {
                        Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
                    } else {
                            if (edt_hotenhv.getText().toString().trim().equals("")
                                ||edt_emailhv.getText().toString().trim().equals("")
                                ||edt_sdthv.getText().toString().trim().equals("")
                                ||edt_diachihv.getText().toString().trim().equals(""))
                        {
                            Toast.makeText(Tttk_Update.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        } else {
//                                String query ="UPDATE taikhoan_hv SET hoten_hv=N'"+edthotenhv+"'," +
//                                        " email_hv='"+edtemailhv+"', sdt_hv='"+edtsdthv+"'," +
//                                        " diachi_hv='"+edtdiachihv+"' WHERE tentaikhoan_hv='"+tentaikhoan+"'";
//                                Statement st = connect.createStatement();
//                                st.executeUpdate(query);
//                                    String query = "update taikhoan_hv set hoten_hv = ?, email_hv = ?, sdt_hv = ?, diachi_hv = ?  where tentaikhoan_hv = '"+tentaikhoan+"'";
//                                    PreparedStatement pst = connect.prepareStatement(query);
//                                    pst.setString(1,edthotenhv);
//                                    pst.setString(2,edtemailhv);
//                                    pst.setString(3,edtsdthv);
//                                    pst.setString(4,edtdiachihv);
//                                    pst.executeUpdate();
//                                    Toast.makeText(getApplicationContext(),"Cập nhật thành công", Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(Tttk_Update.this, MainActivity.class));
//                                    connect.close();
                                SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                String tv_tentaikhoanhv = mPreferences.getString("Tentaikhoanhv","");
                                String hoten = edt_hotenhv.getText().toString();
                                String email = edt_emailhv.getText().toString();
                                String sdt = edt_sdthv.getText().toString();
                                String diachi = edt_diachihv.getText().toString();
                                String query = "update tthv set Hotenhv = '"+hoten+"' ,Emailhv = '"+email+"', Sdthv='"+sdt+"' ,Diachihv='"+diachi+"' \n" +
                                        "where Tentaikhoanhv='"+tv_tentaikhoanhv+"'";
                                PreparedStatement pst = connect.prepareStatement(query);
                                pst.executeUpdate();
                                Toast.makeText(getApplicationContext(),"Cập nhật", Toast.LENGTH_SHORT).show();
                                connect.close();
                        }
                    }
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }
}
