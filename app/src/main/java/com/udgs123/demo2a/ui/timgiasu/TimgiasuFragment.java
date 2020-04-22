package com.udgs123.demo2a.ui.timgiasu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.udgs123.demo2a.R;

import java.sql.Connection;

public class TimgiasuFragment extends Fragment {


    View v;
    Button btn_xacnhan;
    Connection connect;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_timgiasu, container, false);
        return v;
//     final Button   btn_xacnhan = (Button) v.findViewById(R.id.btn_xacnhan);
//        btn_xacnhan.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final EditText tenlop = v.findViewById(R.id.edt_tenlop);
//                final EditText tenmon = v.findViewById(R.id.edt_tenmon);
//                final EditText ngaybatdau = v.findViewById(R.id.edt_ngaybatdau);
//                final EditText soluonggiohoc = v.findViewById(R.id.edt_soluonggiohoc);
//                final EditText soluongbuoihoc = v.findViewById(R.id.edt_soluongbuoihoc);
//                final EditText ngayhoc = v.findViewById(R.id.edt_ngayhoc);
//                final EditText giohoc = v.findViewById(R.id.edt_giohoc);
//                final EditText mota = v.findViewById(R.id.edt_mtyeucau);
//                final ProgressBar progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
//                if (tenlop.getText().toString().trim().equals("")||tenmon.getText().toString().trim().equals("")
//                        ||ngaybatdau.getText().toString().trim().equals("")
//                        ||soluonggiohoc.getText().toString().trim().equals("")
//                        ||soluongbuoihoc.getText().toString().trim().equals("")
//                        ||ngayhoc.getText().toString().trim().equals("")
//                        ||giohoc.getText().toString().trim().equals("")
//                        ||mota.getText().toString().trim().equals("")) {
//                    Toast.makeText(getActivity(), "Hãy nhập đầy đủ thông tin! ", Toast.LENGTH_SHORT).show();
//                } else {
//                    try {
//                        ConnectHelper connectionHelper= new ConnectHelper();
//                        connect=connectionHelper.connections();
//                        if ( connect == null ) {
//                            Toast.makeText( getActivity(), "Kiểm tra kết nối của bạn! ", Toast.LENGTH_SHORT).show();
//                        }
//                        else {
//                            try {
//                                PreparedStatement pst = connect.prepareStatement("insert into timgs values(?,?,?,?,?,?,?,?)");
//                                pst.setString(1, tenlop.getText().toString().trim());
//                                pst.setString(2, tenmon.getText().toString().trim());
//                                pst.setString(3, ngaybatdau.getText().toString().trim());
//                                pst.setString(4, soluonggiohoc.getText().toString().trim());
//                                pst.setString(5, soluongbuoihoc.getText().toString().trim());
//                                pst.setString(6, ngayhoc.getText().toString().trim());
//                                pst.setString(6, giohoc.getText().toString().trim());
//                                pst.setString(6, mota.getText().toString().trim());
//                                pst.executeUpdate();
//                                Toast.makeText(getActivity(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
//                                //startActivity(new Intent(TimgiasuFragment.this, dangnhap.class));
//                                connect.close();
//                            } catch (SQLException e) {
//                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }catch (Exception ex)
//                    {
//                        Toast.makeText(getActivity(),ex.getMessage(), Toast.LENGTH_LONG).show();
//                        progressBar.setVisibility(View.INVISIBLE);
//                    }
//            }
//        } );
    }
}