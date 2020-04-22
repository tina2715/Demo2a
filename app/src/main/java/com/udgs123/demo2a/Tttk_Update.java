package com.udgs123.demo2a;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.Statement;

public class Tttk_Update extends AppCompatActivity {
    EditText edt_hotenhv, edt_emailhv, edt_sdthv, edt_diachihv;
    EditText tv_tentaikhoanhv;
    Connection connect;
    Button btn_luu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tttk__update);

        tv_tentaikhoanhv = (EditText) findViewById(R.id.tv_tentaikhoanhv);
        edt_hotenhv = (EditText) findViewById(R.id.edt_hotenhv);
        edt_emailhv = (EditText) findViewById(R.id.edt_emailhv);
        edt_sdthv = (EditText) findViewById(R.id.edt_sdthv);
        edt_diachihv = (EditText) findViewById(R.id.edt_diachihv);
        btn_luu = (Button) findViewById(R.id.btn_luu);






        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //SharedPreferences.Editor editor = mPreferences.edit();

        final String tentaikhoan = mPreferences.getString( "Tentaikhoanhv","" );
        //final String tentaikhoan = getIntent().getStringExtra("tentaikhoan_hv");

//        try {
//        ConnectHelper connectHelper = new ConnectHelper();
//        connect =connectHelper.connections();
//            if (connect==null){
//                Toast.makeText( getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_SHORT ).show();
//            } else {
//                    String query ="SELECT * FROM taikhoan_hv WHERE tentaikhoan_hv='"+tentaikhoan+"'";
//                    Statement st = connect.createStatement();
//                    ResultSet rs = st.executeQuery(query);
//                    while (rs.next()){
//                        tv_tentaikhoanhv.setText(rs.getString("tentaikhoan_hv"));
////                        edt_hotenhv.setText(rs.getString("hoten_hv"));
////                        edt_emailhv.setText(rs.getString("email_hv"));
////                        edt_sdthv.setText(rs.getString("sdt_hv"));
////                        edt_diachihv.setText(rs.getString("diachi_hv"));
//                    }
//            }
//        } catch (Exception e) {
//            Toast.makeText( getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT ).show();
//        }


        btn_luu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  edt_hotenhv.setText(getIntent().getStringExtra("Hotenhv"));
                  edt_emailhv.setText(getIntent().getStringExtra("Emailhv"));
                  edt_sdthv.setText(getIntent().getStringExtra("Sdthv"));
                  edt_diachihv.setText(getIntent().getStringExtra("Diachihv"));
//                final String edthotenhv = edt_hotenhv.getText().toString().trim();
//                final String edtemailhv = edt_emailhv.getText().toString().trim();
//                final String edtsdthv = edt_sdthv.getText().toString().trim();
//                final String edtdiachihv = edt_diachihv.getText().toString().trim();

                try {
                    ConnectHelper connectHelper = new ConnectHelper();
                    connect = connectHelper.connections();
                    if (connect==null) {
                        Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
                    } else {
                            if (tv_tentaikhoanhv.getText().toString().trim().equals("")||edt_hotenhv.getText().toString().trim().equals("")
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

                                //String tentaikhoan = tv_tentaikhoanhv.getText().toString();
                                String hoten = edt_hotenhv.getText().toString();
                                String email = edt_emailhv.getText().toString();
                                String sdt = edt_sdthv.getText().toString();
                                String diachi = edt_diachihv.getText().toString();
                                String query = "UPDATE thongtinhocvien SET Hotenhv= '"+hoten+"',Emailhv= '"+email+"',Sdthv= '"+sdt+"',Diachihv= '"
                                        +diachi+"'WHERE Tentaikhoanhv= '"+tentaikhoan+"' ";
                               // Log.d( "BBB", query );
                                Statement st = connect.createStatement();
                                st.executeUpdate(query);
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
